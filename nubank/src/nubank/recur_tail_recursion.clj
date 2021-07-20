(ns nubank.recur-tail-recursion)

(def releases [0 32 35 -5 -1 12 17 21 23 -10 -40 50])

(defn is-major-than-zero?
  "test vector size is not empty"
  [number]
  (>= number 1)
  )

(defn remove-element
  [vector]
  (if (not (nil? vector))
    (do (def vector-size (count vector))))

  (if (is-major-than-zero? vector-size)
    (do
      (println "removing" (vector 0) "element")
      (println "current elements" (vec (rest vector)))
      (println "- - - - - - - - -")
      (recur (remove-element (vec (rest vector))))
      ))
  )

(remove-element releases)