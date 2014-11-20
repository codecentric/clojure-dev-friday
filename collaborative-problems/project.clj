(defproject cdfprep "0.1.0-SNAPSHOT"
  :description "Server and dashboard component for collaborative Clojure problem solving."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-alpha4"]
                 [enlive "1.1.1"]
                 [http-kit "2.1.16"]
                 [cheshire "4.0.4"]
                 [hiccup "1.0.5"]
                 [compojure "1.1.8"]
                 [ring "1.1.6" :exclusions [ring/ring-jetty-adapter]]
                 [reagent "0.4.2"]
                 [prismatic/schema "0.3.3"]
                 [prismatic/fnhouse "0.1.0"]
                 [org.clojure/clojurescript "0.0-2371"]]

  :profiles {:dev {:cljx {:builds [{:source-paths ["src/cljx"]
                                    :output-path "target/generated/src/clj"
                                    :rules :clj}
                                   {:source-paths ["src/cljx"]
                                    :output-path "target/generated/src/cljs"
                                    :rules :cljs}]}
                   :plugins [[lein-cljsbuild "1.0.3"]
                             [com.keminglabs/cljx "0.3.2" :exclusions [org.clojure/clojure]]]}}

  :main problemserver.server
  :source-paths ["src/clj" "target/generated/src/clj"]
  :repl-options {:nrepl-middleware [cljx.repl-middleware/wrap-cljx]}
  :cljsbuild {:builds
               [{:id "problems"
                 :source-paths ["src/clj" "target/generated/src/cljs"]
                 :compiler {:optimizations :advanced
                            :output-to "resources/public/js/out/client.js"
                            :output-dir "resources/public/js/out"
                            :source-map "resources/public/js/out/client.js.map"
                            :warnings true
                            :pretty-print false}}]}
  :aliases {"ca" ["cljsbuild" "auto"]})
