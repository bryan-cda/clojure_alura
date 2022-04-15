(ns clojure.model.hospital
  (:use clojure.pprint)
  (:require [schema.core :as s
             :include-macros true]))

(s/set-fn-validation! true)

(def PosInt (s/pred pos-int? "not int"))

(def Patient
  {:id PosInt :name s/Str})

(s/defn patient-builder :- Patient
  [id :- PosInt name :- s/Str]
  {:id id, :name name})

(pprint (s/validate Patient {:id 1 :name "Bryan"}))

(pprint (patient-builder 1 "Olavo"))

(defn major-or-equal-to-zero? [amount]
  (>= amount 0))

(def Financial (s/constrained s/Num major-or-equal-to-zero?))

(def Request
  {:patient Patient
   :amount Financial
   :procedure s/Keyword})

(s/defn new-consult :- Request
  [patient :- Patient, amount :- Financial, procedure :- s/Keyword]
  {:patient patient, :amount amount, :procedure procedure})

(pprint (new-consult (patient-builder 1, "Bar"), 110, :x-ray))

;(pprint (new-consult (patient-builder 1, "Foo"), -110, :x-ray))
;error validation on pass zero for id (not (pos-int?))
;(pprint (s/validate Patient {:id 0 :name "Bryan"}))