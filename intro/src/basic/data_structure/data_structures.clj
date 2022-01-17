(ns basic.data-structure.data_structures
  (:import (clojure.lang PersistentQueue))
  (:use [clojure pprint])
  (:require [hospital.model.hospital :as m.hospital]))

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

;test with atom and swap using map
(defn atom-map-test []
  (let [atom-map (atom {:password-queue m.hospital/empty-queue})]
    (println atom-map)
    (pprint atom-map)
    (pprint (deref atom-map))
    (pprint @atom-map)
    (swap! atom-map assoc :normal-queue m.hospital/empty-queue)
    (swap! atom-map update :normal-queue conj "Omen")
    (swap! atom-map update :password-queue conj "Sage")
    (swap! atom-map update :normal-queue conj "Skye")
    (swap! atom-map assoc :priority m.hospital/empty-queue)
    (swap! atom-map assoc :urgency m.hospital/empty-queue)
    (pprint @atom-map)
    ))

;test with atom and swap using list
(defn atom-list-test []
  (let [empty-list (atom '())]

    ;print add element on atomic list but dont modify the state
    (pprint (conj @empty-list 123))

    ;print after conj and the list is empty as the creation
    (pprint @empty-list)

    ;modifying state with swap
    (swap! empty-list conj "Raze")
    (swap! empty-list conj "Skye")
    (swap! empty-list conj "Sage")
    (swap! empty-list conj "Astra")
    (swap! empty-list conj "Reyna")
    (swap! empty-list conj "Killjoy")
    (swap! empty-list conj "Jetty")
    (swap! empty-list conj "Phoenix")
    (swap! empty-list conj "Breach")
    (swap! empty-list conj "Sova")
    (swap! empty-list conj "Brimstone")
    (swap! empty-list conj "K/O")
    (swap! empty-list conj "Yoru")
    (swap! empty-list conj "Cypher")

    ;verify if list have element inside
    (pprint @empty-list)))


(normal-vector)
(normal-list)
(normal-set)
(normal-queue)
(atom-map-test)
(atom-list-test)