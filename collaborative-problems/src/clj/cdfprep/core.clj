(ns cdfprep.core
  (:require [net.cgrand.enlive-html :as enlive]
            [clojure.string :as str]
            [clojure.java.io :as io]
            [org.httpkit.client :as http]))

(def rows
  (enlive/select (enlive/html-resource (java.net.URL. "http://www.4clojure.com/problems"))
                 [:#problem-table :tr]))

(def header-row
  (first rows))

(def data-row-contents
  (map :content (rest rows)))

(def column->index
  (->> header-row
       :content
       (map-indexed (fn [idx {:keys [content]}]
                      [(first content) idx]))
       (into {})))

(defn problem-number [data-row-content]
  (-> data-row-content
      (nth (get column->index "Title"))
      :content
      first
      (:attrs)
      (:href)
      (str/split #"/")
      (last)))

(defn difficulty [data-row-content]
  (-> data-row-content (nth (get column->index "Difficulty")) (:content) (first)))

(def problems
  (->> data-row-contents
       (map (juxt problem-number difficulty))
       (map (partial zipmap [:problem-number :difficulty]))))

(def difficulty->problems
  (->> problems
       (group-by :difficulty)
       (map (juxt first (comp (partial map :problem-number) second)))
       (into {})))

(def offline4clojure-filename "/Users/gerrithentschel/cc/offline-4clojure/src/offline_4clojure/p%s.clj")

(defn file-name-for-problem [problem-number]
  (format offline4clojure-filename problem-number))

(def difficulty->files
  (->> difficulty->problems
       (map (fn [[d problem-numbers]]
              [d (map (comp slurp io/file file-name-for-problem)
                      problem-numbers)]))))


