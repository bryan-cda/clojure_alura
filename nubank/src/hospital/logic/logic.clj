(ns hospital.logic.logic)

  (defn enter-waiting-queue
    [hospital queue person]
   (update hospital queue conj person))

(defn attend-patient
  [hospital department]
  (update hospital department pop))
