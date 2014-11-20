(ns problemserver.schemas
  (:require [schema.core :as s :include-macros true]))

(defn problem-id? [s]
  (re-find #"^problem\d+$" s))

(s/defschema ProblemId
             "problem1, problem2, ..."
             (s/both s/Str
                     (s/pred problem-id?)))


(def ProblemCategory (s/enum :elementary
                             :easy
                             :normal
                             :advanced
                             :java8))

(s/defschema TestResults
             "Test result schema"
             #{{:test/id     ProblemId
                :test/result (s/enum :pass
                                     :fail
                                     :error)
                :test/source s/Str}})

(s/defschema ResultData
             "Schema for test results submitted by test clients"
             {:user/id       s/Str
              :problem-level ProblemCategory
              :results       TestResults})

(s/defschema ServerDataSchema
             "Schema of combined test results on the server"
             {:progress {(s/named s/Str "client id")
                          {ProblemCategory TestResults}}
              ;; how to specify a map with a single dynamic key?
              :delta    ResultData})

(s/defschema DashboardDataSchema
             "Schema of data pushed to the result dashboard (javascript clients)"
             {:results
               {ProblemCategory
                 {ProblemId
                   {:pass                       s/Num
                    :fail                       s/Num
                    :error                      s/Num
                    (s/optional-key :solutions) #{(s/named s/Str "solution-source")}}}}
              :solutions/selected {:problem-name ProblemId
                                   :solutions #{s/Str}}})

(s/defschema AcceptedResults (s/eq ""))
