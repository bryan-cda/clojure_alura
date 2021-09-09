(ns hospital.data-structure.data_structures
  (:import (clojure.lang PersistentQueue))
  (:use [clojure pprint])
  )

(defn normal-vector []
  (let [passwords ["ND10" "N11" "N12" "N13"]]
    (println passwords)
    (println (conj passwords "N14"))
    (println (pop passwords))
    ))

(defn normal-list []
  (let [passwords '(111 222)]
    (println passwords)
    (println (conj passwords 333))
    (println (pop passwords))
    ))

(defn normal-set []
  (let [passwords #{"N15" "N16" "N17"}]
    (println passwords)
    (println (conj passwords "N18"))
    ;(println (pop passwords)) set is not stack so pop cannot be used.
    )
  )

(defn normal-queue []
  "Initialize queue with default values"
  (let [passwords (conj PersistentQueue/EMPTY "001" "002" "003") ]
    (println "current queue: " (seq passwords))
    (println "add new value in queue" (seq (conj passwords "004")))
    (println "first element of queue: " (peek passwords))
    (println "removing first element" (seq (pop passwords)))
    (pprint passwords)
    ))

(normal-vector)
(normal-list)
(normal-set)
(normal-queue)