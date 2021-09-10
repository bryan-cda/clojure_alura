(ns hospital.logic.logic
  (:use (clojure pprint)))

(defn current-queue-have-space?
  [hospital queue]
  (->
    hospital
    (get,,, queue)
    count,,,
    (< ,,, 5)))

(defn enter-waiting-queue
  [hospital queue person]
    (if (current-queue-have-space? hospital queue)
      (update hospital queue conj person)
      (throw (ex-info "Full queue" {:try-to-add-new-person person}))))

(defn attend-patient
  [hospital department]
  (update hospital department pop))
