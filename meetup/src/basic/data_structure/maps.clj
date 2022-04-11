(ns basic.data_structure.maps)

(def ir-fee-discount {1903.98 0.00
                      2826.65 0.07
                      3751.05 0.15
                      4664.68 0.22
                      })

(println (keys ir-fee-discount))
(println (vals ir-fee-discount))
(println (count ir-fee-discount))

(def queue {
            :player-1 {:nick "madara" :agent-1 "Raze"} ,
            :player-2 {:nick "talion" :agent-2 "Sova"} ,
            :player-3 {:nick "lrabbt" :agent-3 "Breach"} ,
            :player-4 {:nick "darkmega" :agent-4 "Phoenix"} ,
            :player-5 {:nick "rodrigodebossans" :agent-5 "Reyna"}})

(def numbers {:first {:second 2 :third 3} })

(println queue)
(println (assoc queue :player-6 "other" :agent-6 "KAY/O"))


(println (update numbers :first :second inc))

(println (queue :player-1))
(println (queue :player-2))
(println (queue :player-3))
(println (queue :player-4))
(println (queue :player-5))

(println (queue :player-6 "not found {}"))

(println (:player-1 queue {}) )
(println (:player-2 queue {}))
(println (:player-3 queue {}))
(println (:player-4 queue {}))
(println (:player-5 queue {}))


(println (:agent-5 queue))
(println (:agent-4 queue))
(println (:agent-3 queue))
(println (:agent-2 queue))
(println (:agent-1 queue))

(-> numbers
    :first
    :second
    println)

(-> queue
    :player-1
    :agent-1
    println)