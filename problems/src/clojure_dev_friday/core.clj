(ns clojure-dev-friday.core
  (:import [java.net InetAddress]
           [java.io PushbackReader LineNumberReader File FileReader InputStreamReader])
  (:require clojure.test
            [robert.hooke :refer [add-hook]]
            [clojure.java.io :as io]
            [org.httpkit.client :as http]
            [clojure.string :as str]
            [clojure.pprint :refer [pprint]]))

(defonce test-reports (atom []))

(defn publish-results [f test-result-map]
  (swap! test-reports conj test-result-map)
  (f test-result-map))

(defn var-name [var]
  (-> var meta :name))

(defn var-ns [var]
  (-> var meta :ns))

(defn problem-level [report]
  (-> report (:ns) (ns-name) (str) (str/split #"-") (last) (keyword)))

(defn read-var-source [problem-var rdr]
  (with-open [rdr (LineNumberReader. rdr)]
    (dotimes [_ (dec (:line (meta problem-var)))] (.readLine rdr))
    (let [text (StringBuilder.)
          pbr (proxy [PushbackReader] [rdr]
                (read [] (let [i (proxy-super read)]
                           (.append text (char i))
                           i)))]
      (if (= :unknown *read-eval*)
        (throw (IllegalStateException. "Unable to read source while *read-eval* is :unknown."))
        (read (PushbackReader. pbr)))
      (str text))))

(defn source-fn
  [problem-var]
  (when-let [filepath (:file (meta problem-var))]
    (let [^File file (io/file filepath)]
      (if (.exists file)
        (read-var-source problem-var (FileReader. file))
        (read-var-source problem-var (InputStreamReader. (.getResourceAsStream Class (str "/" filepath))))))))

(defn find-solution-var
  ([test-var-symbol]
   (find-solution-var *ns* test-var-symbol))
  ([ns test-var-symbol]
   (find-var (symbol (str ns) (str "_p" (.substring (str test-var-symbol) (count "problem")))))))

(defn gather-test-results [test-reports-state]
  (-> (reduce (fn [{:keys [test-name test-source] :as acc}
                   {:keys [type] :as report}]
                (cond (= type :begin-test-var)
                      (-> acc
                          (assoc :test-name (var-name (:var report)))
                          (assoc :test-source (source-fn (find-solution-var (var-ns (:var report))
                                                                            (var-name (:var report))))))

                      (contains? #{:fail :pass :error} type)
                      (update acc :results conj {:test/id     (str test-name)
                                                 :test/result type
                                                 :test/source test-source})
                      (= type :begin-test-ns)
                      (assoc acc :problem-level (problem-level report))
                      :else
                      acc))
              {:test-name nil
               :test-source ""
               :results   #{}}
              test-reports-state)
       (select-keys [:results :problem-level])))

(defn results-body [test-reports]
  (-> test-reports
      (deref)
      (gather-test-results)
      (assoc :user/id
        (.getHostAddress (InetAddress/getLocalHost)))
      (pr-str)))

(defn post-results [test-reports]
  (http/put "http://clojuredevfriday-codecentric2.rhcloud.com/results"
             {:body (results-body test-reports)
              :headers {"content-type" "application/edn"}}))

(defn reset-and-report-results! [f & args]
  (if (empty? args)
    (do (reset! test-reports [])
        (let [result (apply f args)]
          (future (let [response @(post-results test-reports)]
                    (when (not= 200 (:status response))
                      (pprint "server rejected test-results: " response))))
          result))
    (apply f args)))

(add-hook #'clojure.test/do-report
          #'publish-results)

(add-hook #'clojure.test/run-tests
          #'reset-and-report-results!)

(defmacro solve [pname & body]
  (let [pvar (find-solution-var pname)]
    (when (and pvar (bound? pvar))
      `(clojure.test/deftest ~pname (clojure.test/are [solution#] solution# ~@body)))))
