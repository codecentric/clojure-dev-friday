(ns cdfprep.api
  (:require [clojure.string :as str]
            [clojure.java.io :as io]
            [org.httpkit.client :as http]
            [cheshire.core :as json]))

(defn commented [somestr]
  (str ";; "
       (str/replace somestr #"\n" "\n;;")))

(defn strip-cr [somestr]
  (str/replace somestr "\r" ""))

(defn update-test-var [problem-number test]
  (str/replace test #"__" (str "_p" problem-number)))

(defn get-tests [tests problem-number]
  (strip-cr (str/join "\n  " (map (partial update-test-var problem-number) tests))))

(defn get-problem-data [problem-number]
  (println "get" problem-number)
  (try (-> (format "http://www.4clojure.com/api/problem/%d" problem-number)
       (http/get)
       (deref)
       (:body)
       (json/parse-string true)
       (assoc :number problem-number))
       (catch Exception e
         (println "error" (.getMessage e) " - problem: " problem-number))))

(defn problem-string [problem-data]
  (format ";; Problem %d:  %s\n;; %s\n(def _p%d\n  ;;TODO your solution here\n  )\n\n(solve problem%d \n  %s)\n\n"
          (:number problem-data)
          (:title problem-data)
          (:description problem-data)
          (:number problem-data)
          (:number problem-data)
          (get-tests (:tests problem-data) (:number problem-data))))


(defn problems [x y] (doall (pmap get-problem-data (range x y))))

(defn problems-strings-by-difficulty [problems]
  (->> (group-by :difficulty problems)
       (map (fn [[difficulty probs]]
              [difficulty (str/join (map problem-string probs))]))))

(defn problems-file-string [difficulty problems-string]
  (format "(ns clojure-dev-friday.problems-%s\n  (:require [clojure-dev-friday.core :refer [solve]]\n            [clojure.test :refer [run-tests]]))\n%s"
          (.toLowerCase difficulty)
          problems-string))

(defn process-problems [problems]
  (doseq [[difficulty file-text] (->> problems
                                      (problems-strings-by-difficulty)
                                      (map (fn [[difficulty problems-string]]
                                             [difficulty (problems-file-string difficulty problems-string)])))]
    (spit (io/file (format "problems_%s.clj" (.toLowerCase difficulty)))
          file-text)))