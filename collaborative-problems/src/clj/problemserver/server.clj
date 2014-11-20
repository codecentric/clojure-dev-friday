(ns problemserver.server
  (:require [org.httpkit.server :as httpkit]
            [clojure.tools.nrepl.server :as nrepl]
            [compojure.handler :as handler]
            [ring.util.response :as response]
            [plumbing.core :refer [map-vals]]
            [clojure.edn :as edn]
            [ring.util.response :as response]
            [ring.middleware.resource :as resources]
            [ring.middleware.file-info :as file-info]
            [hiccup.page :refer [html5]]
            [compojure.core :refer :all]
            [plumbing.core :refer [defnk]]
            [problemserver.schemas :as schemas]
            [fnhouse.routes :as fnroutes]
            [fnhouse.docs :as docs]
            [fnhouse.handlers :as handlers]
            [fnhouse.middleware :as middleware]
            [clojure.pprint :refer [pprint]])
  (:gen-class))

(defn layout [body]
  (html5
    [:head
     [:title "Codecentric Clojure Dev Friday - Tests"]
     [:meta {:name "charset" :content "utf-8"}]
     [:link {:rel "stylesheet" :href "//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"}]
     [:link {:rel "stylesheet" :href "css/style.css"}]
     [:link {:rel "stylesheet" :href "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"}]]
    [:body (list body
                 [:script {:src "http://fb.me/react-0.9.0.js"}]
                 [:script {:src "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"}]
                 [:script {:src "//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"}]
                 [:script {:src "js/out/client.js"}])]))

(defn collab-test-page []
  (layout [:div.container
           [:div#content
            [:h1 "Initializing Websocket connection"]]]))

(defn add-connection! [connections publish-fn]
  (swap! connections conj publish-fn))

(defn remove-connection! [connections publish-fn]
  (swap! connections disj publish-fn))

(defn progress-state-msg [progress-state]
  {:type :state
   :payload progress-state})

(defn delta-msg [delta]
  {:type :delta
   :payload delta})

(defn de-index-server-progress [server-progress-state]
  (mapcat (fn [[client-id category->results]]
            (mapcat (fn [[category test-results]]
                      (map (fn [test-result]
                             (assoc test-result
                               :user/id client-id
                               :problem-level category))
                           test-results))
                    category->results))
          server-progress-state))

(defn sum-results [test-results]
  (reduce (fn [acc {:keys [test/result test/source]}]
            (cond-> (update acc result inc)
                    (= result :pass)
                    (update :solutions conj source)))
          {:pass 0
           :fail 0
           :error 0
           :solutions #{}}
          test-results))

(defn client-transform-initial-state [server-progress-state]
  (->> server-progress-state
       (de-index-server-progress)
       (group-by :problem-level)
       (map-vals (partial group-by :test/id))
       (map-vals (partial map-vals sum-results))))

(defn send-initial-state [channel resources]
  (httpkit/send! channel (-> resources
                             :result-database
                             deref
                             :progress
                             client-transform-initial-state
                             progress-state-msg
                             pr-str)))

(defn handle-receive [channel]
  (httpkit/on-receive
    channel
    (fn [msg]
      (println "somebody sent something?!" msg))))

(defn handle-close [channel resources publish-fn]
  (httpkit/on-close channel (fn [status]
                              (println "closed: " status)
                              (remove-connection! (:client-connections resources)
                                                  publish-fn))))

(defn register-client [channel resources]
  (let [publish-fn (fn [changes]
                     (httpkit/send! channel
                                    (pr-str changes)))]
    (add-connection! (:client-connections resources) publish-fn)
    (send-initial-state channel resources)
    (handle-receive channel)
    (handle-close channel resources publish-fn)))

(defn init-websocket-connection [request resources]
  (httpkit/with-channel request channel
                        (if (httpkit/websocket? channel)
                          (register-client channel resources)
                          (-> "Your browser needs to support WebSockets. Please update!"
                              (response/response)
                              (response/content-type "text/html")))))

(defnk $results$PUT
       "Puts the newest test results of a tester"
       {:responses {200 schemas/AcceptedResults}}
       [[:request body :- schemas/ResultData]
        [:resources result-database]]
       (let [{:keys [user/id problem-level results] :as user-update} body]
         (swap! result-database
                (fn [db-state]
                  (-> db-state
                      (assoc-in [:progress id problem-level] results)
                      (assoc :delta user-update))))
         (println "yes it is: " @result-database)
         (response/response "")))

(defn attach-docs [resources prefix->ns-sym]
  (let [proto-handlers (-> prefix->ns-sym
                           (assoc "docs" 'fnhouse.docs)
                           handlers/nss->proto-handlers)
        all-docs (docs/all-docs (map :info proto-handlers))]
    (-> resources
        (assoc :api-docs all-docs)
        ((handlers/curry-resources proto-handlers)))))

(defn coercion-middleware
  "Wrap a handler with the schema coercing middleware"
  [handler]
  (middleware/coercion-middleware
    handler
    (constantly nil)
    (constantly nil)))


(defn create-routes [resources]
  (defroutes collab-test-routes
    (GET "/" request
         (collab-test-page))
    (GET "/ws" request
         (init-websocket-connection request resources))
    (fnroutes/root-handler (map coercion-middleware (attach-docs resources {"" 'problemserver.server})))))

(defn wrap-edn-body [handler]
  (fn [req]
    (def xx req)
    (if (and (:body req)
             (= "application/edn" (get-in req [:headers "content-type"])))
      (handler (update req :body (comp edn/read-string slurp)))
      (handler req))))

(defn create-app [resources]
  (-> (create-routes resources)
      (handler/site
        {:session {:cookie-attrs {:max-age   (* 60 60 24 365)
                                  :http-only true}}})
      (wrap-edn-body)
      (resources/wrap-resource "public")
      (file-info/wrap-file-info)))

;; just for easier debugging, normally these wouldn't be global
(defonce result-db (atom {}))
(defonce client-connections (atom #{}))

(defn state-delta [{prev-state :progress} {last-change :delta}]
  (let [prev-user-results (get-in prev-state [(:user/id last-change)
                                              (:problem-level last-change)])
        problem-id->test-outcome (into {} (map (juxt :test/id :test/result) prev-user-results))
        problem-id->test-source (into {} (map (juxt :test/id :test/source) prev-user-results))]
    (->> last-change
         (:results)
         (reduce (fn [acc {:keys [test/id test/result test/source]}]
                   (let [prev-result (get problem-id->test-outcome id)]
                     (cond-> acc
                             (not= result prev-result)
                             (assoc id (merge {:pass 0 :fail 0 :error 0} {result 1}))
                             (and (not= result prev-result) prev-result)
                             (assoc-in [id prev-result] -1)
                             (and (= result :pass) (not= (get problem-id->test-source id) source))
                             (update-in [id :solutions] (fnil conj #{}) (with-out-str (pprint (edn/read-string source)))))))
                 {})
         (hash-map (:problem-level last-change)))))

;; invoked via 'lein run'
(defn -main [& _]
  (nrepl/start-server :port 35000 :bind (or (System/getenv "HOST") "0.0.0.0"))
  (add-watch result-db :pusher (fn [_ _ prev-state new-state]
                                 (let [payload (delta-msg (state-delta prev-state new-state))]
                                   (doseq [ws-conn @client-connections]
                                     (ws-conn payload)))))
  (let [options {:ip    (or (System/getenv "HOST") "0.0.0.0")
                 :port  (Integer/parseInt (or (System/getenv "PORT") "8000"))
                 :join? false}]
    (def the-server (httpkit/run-server (create-app {:result-database    result-db
                                                     :client-connections client-connections})
                                        options))
    (println "Server started:" options)))

(comment
  (defn send-tests [results]
    @(cc/put "http://localhost:8000/results" {:body (pr-str results)
                                              :headers {"content-type" "application/edn"}})))