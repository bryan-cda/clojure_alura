(ns hospital.model.hospital
  (:import (clojure.lang PersistentQueue)))

(def empty-queue PersistentQueue/EMPTY)

(defn new-hospital []
  "Manage queues in the hospital"
  {:password-queue empty-queue
   :priority empty-queue
   :normal  empty-queue
   :urgency empty-queue
   })
