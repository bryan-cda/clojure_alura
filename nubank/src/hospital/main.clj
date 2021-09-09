(ns hospital.main
  (:use [clojure pprint])
  (:require [hospital.model.hospital :as m.hospital]
            [hospital.logic.logic :as l.logic]))


(def persons '("Bryan" "Irys" "Marco" "Thais"))

(defn start-hospital-operations []
  (def west-dor (m.hospital/new-hospital))

  (def west-dor (l.logic/enter-waiting-queue west-dor :password-queue "Raze"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :password-queue "Sage"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :password-queue "Reyna"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :urgency "Jetty"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :urgency "Kill Joy"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :urgency "Astra"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :normal "Cypher"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :normal "K/O"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :normal "Yoru"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :normal "Breach"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :priority "Sova"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :priority "Skye"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :priority "Omen"))
  (pprint west-dor)
  (def attended (l.logic/attend-patient west-dor :urgency))
  (pprint attended))

(start-hospital-operations)

