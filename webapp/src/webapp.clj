(ns webapp
  (:require [org.httpkit.server :as httpkit]
            [compojure.handler :as handler]
            [ring.util.response :refer [redirect response]]
            [hiccup.page :refer [html5]]
            [compojure.core :refer [defroutes GET POST]]))

; 1. Use hiccup/enlive to generate an HTML page containing a text input form and an unordered list
; 2. Populate unordered list with messages from an atom
; 3. Add a GET route using compojure that returns the page
; 4. Add a POST route that stores the entered text in the atom and redirects back to the page
; 5. Create a server using http-kit that serves your app

(defn layout [ & body]
  (html5 [:head
               [:title "First webapp"]
               [:link {:rel "stylesheet"
                       :href "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"}]]
         [:body
          body]))


(defn app
  [request]
  {:code 200 :body "Hello World"})


(defn -main []
  (httpkit/run-server (handler/site #'app) {:port 8080 :join? false}))

