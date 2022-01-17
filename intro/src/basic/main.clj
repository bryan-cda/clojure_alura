(ns hospital.main
  (:use [clojure pprint])
  (:require [hospital.model.hospital :as m.hospital]
            [hospital.logic.logic :as l.logic]))

(defn start-hospital-operations []
  (def west-dor (m.hospital/new-hospital))

  (def west-dor (l.logic/enter-waiting-queue west-dor :password-queue "Raze"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :password-queue "Sova"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :password-queue "Sage"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :password-queue "Reyna"))
  (def west-dor (l.logic/enter-waiting-queue west-dor :password-queue "Brimstone"))
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

(defn start-hospital-operations-multi-thread []
  (.start (Thread. (fn [] (println "Thread 1"))))
  (.start (Thread. (fn [] (println "Thread 2"))))
  (.start (Thread. (fn [] (println "Thread 3"))))
  (.start (Thread. (fn [] (println "Thread 4"))))
  (.start (Thread. (fn [] (println "Thread 5"))))
  (.start (Thread. (fn [] (println "Thread 6"))))
  (.start (Thread. (fn [] (println "Thread 7"))))
  (.start (Thread. (fn [] (println "Thread 8"))))
  (.start (Thread. (fn [] (println "Thread 9"))))
  (.start (Thread. (fn [] (println "Thread 10")))))

(start-hospital-operations-multi-thread)

(start-hospital-operations)

