(ns api.api
  (:require [io.pedestal.http.route :as route]
            [io.pedestal.http :as http]))

(defn print-message [] "hello from Clojure")

(defn hello [request]
  {:status 200
   :body   (str "Hello " (get-in request [:query-params :name] (print-message)))})

(defn login
  [request]
  (def username (get-in request [:query-params :username]))
  (def password (get-in request [:query-params :password]))

  (def is-correct-username? (= username "bryan.cda"))
  (def is-correct-password? (= password "q1w2e3"))

  (if (and is-correct-username? is-correct-password?)
    (println "welcome," (if (= username "bryan.cda") "Bryan!" username))
    (println "wrong username or password. try again."))
  )

(defn agents [request]
  {:status 200 :body "Raze, Reyna, Jetty, Phoenix, Sage"})


(defn get-routes [] #{["/hello" :get hello :route-name :hello]
                      ["/agents" :get agents :route-name :list-agents]
                      ["/login" :get login :route-name :login]
                      })

(def routes (route/expand-routes (get-routes)))

(defn get-server-config [] {::http/routes routes ::http/port 9999 ::http/type :jetty ::http/join? false})

(def map-service (get-server-config))

(http/start (http/create-server map-service))