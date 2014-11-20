(ns problemserver.client
  (:require goog.net.WebSocket.EventType
            goog.net.WebSocket
            [goog.events :as events]
            [cljs.reader :as edn]
            [clojure.set :as set]
            [problemserver.schemas :as schemas]
            [schema.core :as s :include-macros true]
            [reagent.core :as reagent :refer [atom]]))

(defonce state (atom {:solutions/selected {:problem-name "problem0"
                                           :solutions #{}}
                     :results {}}
                     :validator (partial s/validate schemas/DashboardDataSchema)))

(defn deep-merge-with
  [f & vs]
  (if (every? map? vs)
    (apply merge-with (partial deep-merge-with f) vs)
    (apply f vs)))

(let [ws (goog.net.WebSocket. true)]
  (events/listen ws
                 goog.net.WebSocket.EventType/MESSAGE
                 (fn [e]
                   (let [payload (edn/read-string (.-message e))]
                     (swap! state
                            update-in
                            [:results]
                            (partial deep-merge-with
                                     (fn [a b] (if (set? a)
                                                 (set/union a b)
                                                 (+ a b))))
                            (:payload payload)))))
  (events/listen ws
                 goog.net.WebSocket.EventType/ERROR
                 (fn [e]
                   (.log js/console (pr-str {:error (.-type e)}))))
  (.open ws (str "ws://" (.-hostname js/location) ":8000/ws")))

(defn show-solutions [problem-name solutions]
  (fn [_]
    (swap! state assoc :solutions/selected {:problem-name problem-name
                                            :solutions solutions})))

(def problem-number (comp js/parseInt #(subs % 7) first))

(defn category-results [category-results]
  [:ul.list-group.problems
   (for [[problem-name {:keys [pass fail solutions]}] (sort-by problem-number category-results)]
     [:li.list-group-item {:key problem-name}
      [:div
       [:h4 problem-name]
       [:div.pull-left [:i.fa.fa-4x.fa-check.pass] [:br] [:span.counted pass]]
       [:div.pull-left [:i.fa.fa-4x.fa-times.fail] [:br] [:span.counted fail]]
       [:div [:button (cond->
                        {:on-click    (show-solutions problem-name solutions)
                         :class       "btn btn-default"
                         :type        "button"
                         :data-toggle "modal"
                         :data-target "#sols"}
                        (empty? solutions)
                        (assoc :disabled "disabled")) "Solutions"]]]])])

(defn solutions-modal [{:keys [problem-name solutions]}]
  [:div#sols.modal.fade
   [:div.modal-dialog
    [:div.modal-content
     [:div.modal-header
      [:button
       {:type "button"
        :class "close"
        :data-dismiss "modal"}
       [:span "x"]]
      [:h4.modal-title problem-name]]
     [:div.modal-body
      (for [solution (sort-by count solutions)]
        [:pre {:key solution} solution])]
     [:div.modal-footer
      [:button {:type "button" :class "btn btn-primary" :data-dismiss "modal"} "Close"]]]]])

(defn testresults []
  [:div
   [solutions-modal (:solutions/selected @state)]
   [:div.container
    [:h1.page-header "Clojure problems - categories"]
    (for [[category problem-results] (:results @state)]
      [:div.panel.panel-default {:key (name category)}
       [:div.panel-heading
        [:h3.panel-title (name category)]]
       [:div.panel-body
        [category-results problem-results]]])]])

(reagent/render-component [testresults]
                          (.-body js/document))