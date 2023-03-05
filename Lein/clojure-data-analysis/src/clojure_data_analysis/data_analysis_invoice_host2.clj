(ns clojure-data-analysis.data-analysis-invoice-host2
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.operators :refer :all])
  )

;connection database properties
(def host "host")
(def port 00000)
(def database-name "data-analysis")
(def collection-name "invoice")

;invoice status
(def invoice-created-status "CREATED_ON_CHARGIFY")
(def invoice-pending-creation "PENDING_CREATION")
(def invoice-error-on-chargify "ERROR_ON_CHARGIFY")


;connect with database
(def database-connection
  (mg/connect {:host host :port port}))

;get database instance
(def database (mg/get-db database-connection database-name))


;find invoice by id
(defn find-invoice-by-batch-id [id]
  (mc/find-maps database collection-name {:batchId id}))

;find invoice by status
(defn find-invoice-by-status [status]
  (mc/find-maps database collection-name {:status status}))

;count invoice by status
(defn count-invoice-by-status [status]
  (mc/count database collection-name {:status status}))

;count invoice by status
(defn count-invoice-by-lot [lot]
  (mc/count database collection-name {:batchId lot}))

;find invoice by id
(defn count-invoice-by-lot-and-status [lot, status]
  (mc/count database collection-name {$and [{:batchId lot} {:status status}]}))

(println (find-invoice-by-batch-id 1))
(println (count-invoice-by-status invoice-created-status))
(println (count-invoice-by-status invoice-pending-creation))
(println (count-invoice-by-status invoice-error-on-chargify))
(println (count-invoice-by-lot 1))
(println (count-invoice-by-lot-and-status 25 invoice-error-on-chargify))
(println (count-invoice-by-lot-and-status 25 invoice-created-status))
(println (count-invoice-by-lot-and-status 25 invoice-pending-creation))

