(ns hospital.record.record
    (:use [clojure pprint])
    (:import (clojure.lang PersistentQueue)))

(defrecord Agent [user name type])

(pprint(Agent. "madara" "Raze" "Duelist"))

(pprint(->Agent "madara" "Raze" "Duelist"))



(defn unpack-record-as-hashmap []
    (let [madara (Agent. "madara" "Raze" "Duelist")]
          (println (:name madara))
          (println (:user madara))
          (println (:type madara))
          (println (vals madara))
          (pprint(assoc (Agent. "madara" "Raze" "Dueslist") :user "Madara"))
          (pprint(class(assoc (Agent. "madara" "Raze" "Dueslist") :user "Madara")))
          (pprint (.user madara))))

(unpack-record-as-hashmap)