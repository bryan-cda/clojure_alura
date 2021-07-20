(ns nubank.for)

(defn account
  [persons]
  (loop [i 0
         rest-persons persons]
    (if (seq rest-persons)
      (recur (inc i) (next rest-persons))
      i)))



(defn extract
  [releases]

  (loop [total-released 0
         rest-release releases
         ]
    (if (seq rest-release)
      (recur (inc total-released) (next rest-release))
      total-released
      )
    )
  )




(println (account ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
;(println (extract [1200 1400 500 100 530]))

(println (account []))
