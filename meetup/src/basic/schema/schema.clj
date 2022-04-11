(ns basic.schema.schema
  (:use clojure.pprint))

(defn add-patient [patients patient]
     (if-let [id (:id patient) ]
                (assoc patients id patient)
                (throw (ex-info "Patients don't have id for " {:patient patient}))))

(defn add-visit [visit-list, patient, visitor]
  (if (contains? visit-list patient)
    (update visit-list patient concat visitor)
    (assoc visit-list patient visitor)))

(defn patient-generator []
  (let [foo {:id 1, :name "Foo"}
        bar {:id 2, :name "Bar"}
        patients (reduce add-patient {} [foo, bar])
        visits {}
        visits (add-visit visits 1 ["01/01/2022"])
        visits (add-visit visits 2 ["01/01/2022", "02/01/2022"])
        visits (add-visit visits 1 ["03/01/2022"])
        ]
        (pprint patients)
        (pprint visits)))

(patient-generator)