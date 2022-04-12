(ns clojure-schemas.schema
  (:use clojure.pprint)
  (:require [schema.core :as s
             :include-macros true]))

(defn add-patient [patients patient]
     (if-let [id (:id patient) ]
       (assoc patients id patient)
       (throw (ex-info "Patients don't have id for " {:patient patient}))))

(defn visit-generator [visit-list, patient, visitor]
  (if (contains? visit-list patient)
    (update visit-list patient concat visitor)
    (assoc visit-list patient visitor)))


(s/defn visit-scheduler [daily-visit-list patient-id schedule-date-and-time]
  (visit-generator daily-visit-list patient-id schedule-date-and-time))


(defn visit-report [patient visits]
  (println "[patient]:"patient"[visits_history]:" (get visits (:id patient))))

(s/defn visit-relation [patient :- Long visits]
  (println "[patient_id]:"patient"[visits_history]:" (get visits patient)))

(defn patient-generator []

  (let [foo {:id 1, :name "Foo"}
        bar {:id 2, :name "Bar"}
        patients (reduce add-patient {} [foo, bar])
        visits (visit-generator foo (:id bar) ["01/01/2022"])]
    (pprint visits)
    (pprint patients)
    (visit-report foo (visit-scheduler {} (:id foo) ["01/01/2022", "02/01/2022"]))
    (visit-relation (:id bar) visits)))

(patient-generator)

(s/set-fn-validation! true)

(s/defn print-number [n :- Long]
  (pprint n))

(print-number 143543435)

;(print-number "15")

