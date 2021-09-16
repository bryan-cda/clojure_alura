(ns hospital.patient.hospital-patient
  (:use [clojure pprint]))

; creating a object types
(defrecord PrivatePatient [id name birth-day])

(defrecord PatientWithHealthInsurance [id name birth-day health-insurance])

; defprotocol seems to be an Java Interface
(defprotocol Chargeable
  (charge? [patient procedure cost]))


; implementing Chargeable
(extend-type PrivatePatient
  Chargeable
  (charge? [patient procedure cost]
    (<= cost 50)))

(extend-type PatientWithHealthInsurance
  Chargeable
  (charge? [patient procedure cost]
    (let [health-insurance (:health-insurance patient)]
      (not (some #(= % procedure) health-insurance)))))

(let [personal (PrivatePatient. 15, "Guilherme", "18/09/1981")
      health-insurance (PatientWithHealthInsurance. 15, "Guilherme", "18/9/1981", [:x-ray :magnetic-resonance])]
  (pprint (charge? personal, :x-ray, 500))
  (pprint (charge? health-insurance, :x-ray, 40))
  (pprint (charge? health-insurance, :magnetic-resonance, 20)))