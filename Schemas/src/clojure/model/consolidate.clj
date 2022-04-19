(ns clojure.model.consolidate
  (:use clojure.pprint)
  (:require [schema.core :as s
             :include-macros true]))

(s/set-fn-validation! true)

;define schema named PosInt that verify if number is integer and positive
(def PosInt (s/pred pos-int? "is positive"))

;define symbol Plan as a Keyword
(def Plan [s/Keyword])

;define symbol Patient as a map
(def Patient
  {:id PosInt
   :name s/Str
   :plan Plan
   (s/optional-key :birthday) s/Str})

;define symbol Patients as a list as a map with id PosInt as a key and Patient as a value
(def Patients
  {PosInt Patient})

;define symbol Visits as a map
(def Visits
  {PosInt [s/Str]})

;method that add patients to a patients list if id exists
(defn add-patient
  [patients patient]
  (if-let [id (:id patient)]
    (assoc patients id patient)
    (throw (ex-info "Patient list don't have id" {:patient patient}))))


; { 15 [], 20 [], 25 []}
(defn add-visit
  [visits, patient, new-visits]
  (if (contains? visits patient)
    (update visits patient concat new-visits)
    (assoc visits patient new-visits)))

(defn print-patient-report [visits, patient]
  (println "Visits of patient" (:name patient) "is" (get visits (:id patient))))

(defn patient-use-test []
  (let [john {:id 15, :name "John"}
        due {:id 20, :name "Due"}
        foo {:id 25, :name "Foo"}

        patients (reduce add-patient {} [john, due, foo])

        visits {}

        visits (add-visit foo 25 ["01/03/2019"])]

    (println "Patients ###")
    (pprint patients)
    (println "")

    (println "Visits ###")
    (pprint visits)
    (println "")

    (println "Visits report ###")
    (print-patient-report visits foo)
    (println "")))

;(pprint (add-visit {} 12 ["01/01/2022"]))
;(pprint (add-visit {12 ["01/01/2022"]} 12 ["01/01/2023"]))
;(pprint (add-visit {12 ["01/01/2022" "01/01/2023"]} 12 ["01/01/2024"]))

(patient-use-test)
