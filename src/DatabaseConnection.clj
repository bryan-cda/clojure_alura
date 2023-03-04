(ns DatabaseConnection
  (:require [monger.core :as mg])
  (:import [com.mongodb MongoOptions ServerAddress]))

;; given host, given port
(let [conn (mg/connect {:host "mongodb://localhost" :port 27017})])


