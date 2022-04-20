(ns tests.logic.logic)

(defn fit-in-queue?
  [hospital department]
  (when-let [queue (get hospital department)]
    (->
      queue
      count
      (<= 5))))