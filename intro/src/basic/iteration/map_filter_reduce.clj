(ns nubank.map-filter-reduce)

(println "Clojure Function Map, Filter and Reduce")

; Function that verify positive or negative released balance
(defn positive-or-not?
  "Verify if release is positive or not"
  [balance]
  (if (> balance 0)
    balance
    nil
    ))

; Function that return the balance of account
(defn get-extract
  "Take the extract of releases"
  [balance]
  (def account-balance (+ balance))
  (positive-or-not? balance)
  )

(def releases [0 32 35 -5 -1 12 17 21 23 -10 -40 50])

(def schedule [(range 1 300 3)])

; Apply operation in each element of vector
(println (map get-extract releases))

; Return just each even element of vector
(println (filter even? releases))

; Filter elements of vector
(println (filter positive-or-not? releases))

(println (reduce + releases))

; Reduce the vector to one element in sum operation
(println (reduce + (range 30)))

(println schedule)

; Reduce the vector to one element in sum operation
(println (reduce + schedule))

; Print each element of vector
(map (println "pure map ->" releases))

; Return the first element of vector
(println (first releases))

; Return all elements of vector without the first
(println (rest releases))

;Build a sequence
(println (seq [(range 10)]))

; Return all elements of vector without the first
(println (next releases))



(


