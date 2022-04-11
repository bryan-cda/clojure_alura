(ns clojure-schemas.schema
  (:use clojure.pprint))

(defn add-patient [patients patient]
     (if-let [id (:id patient) ]
                (assoc patients id patient)
                (throw (ex-info "Patients don't have id for " {:patient patient}))))

(defn visit-generator [visit-list, patient, visitor]
  (if (contains? visit-list patient)
    (update visit-list patient concat visitor)
    (assoc visit-list patient visitor)))

(defn visit-scheduler [daily-visit-list patient-id schedule-date-and-time]
  (pprint "[Daily visits]")
  (visit-generator daily-visit-list patient-id schedule-date-and-time))


(defn visit-report [patient visits]
  (println "[Patient]:"patient"[Visits]:" (get visits (:id patient)))
  )

(defn patient-generator []
  (let [foo {:id 1, :name "Foo"}
        bar {:id 2, :name "Bar"}
        admin {:id 3, :name "admin"}
        employee {:id 4, :name "employee"}
        patients (reduce add-patient {} [foo, bar, admin, employee])]
        (println (visit-report foo (visit-scheduler {} (:id foo) ["01/01/2022", "02/01/2022"])))
        (pprint patients)))


(patient-generator)
