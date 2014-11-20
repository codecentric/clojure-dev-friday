(defproject clojure-dev-friday "0.1.0-SNAPSHOT"
  :description "Get ready for Clojure!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :aliases {"rr" ["repl" ":headless" ":port" "5001"]}
  :dependencies [[org.clojure/clojure "1.7.0-alpha4"]
                 [prismatic/plumbing "0.3.5"]
                 [http-kit "2.1.16"]
                 [robert/hooke "1.3.0"]])