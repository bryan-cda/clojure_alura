(ns clojure.schema.schema
  (:use clojure.pprint)
  (:require [schema.core :as s
             :include-macros true]))

(s/set-fn-validation! true)


(s/defn add-patient [patients patient]
     (if-let [id (:id patient) ]
       (assoc patients id patient)
       (throw (ex-info "Patients don't have id for " {:patient patient}))))

(s/defn visit-generator [visit-list patient :- Long, visitor :- [String]]
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

;valid if is number
(s/defn print-number [n :- Long]
  (pprint n))


(print-number 143543435)


(defn f [n]
  (> n 0))

(def TestPositiveNumber (s/pred is-positive? "positive"))

(pprint (s/validate TestPositiveNumber 15))

(println "is positive? " (pos? -1))

(s/def Patient
  {:id (s/constrained s/Int is-positive?)  :name s/Str})

(pprint (s/validate Patient {:id 145 :name "Cora"}))

;(pprint (s/validate Patient {:id -145 :name "Cora"}))

;(pprint (s/validate TestPositiveNumber -5))

;(print-number "15")

