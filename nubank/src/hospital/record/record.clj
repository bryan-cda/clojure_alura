(ns hospital.record.record
    (:use [clojure pprint])
    (:import (clojure.lang PersistentQueue)))

(defrecord Agent [user name type])

(pprint (Agent. "Doctor" "Jane" "Surgery"))

(defn unpack-record-as-hashmap []
    (let [madara (Agent. "Doctor" "John" "Dentist")]
          (println (:name madara))
          (println (:user madara))
          (println (:type madara))
          (println (vals madara))
          (pprint(assoc (Agent. "Doctor" "Jane" "Surgery") :user "Female Doctor"))
          (pprint(class(assoc (Agent. "Doctor" "Jane" "Surgery") :user "Female Doctor")))
          (pprint (.user madara))))

(unpack-record-as-hashmap)