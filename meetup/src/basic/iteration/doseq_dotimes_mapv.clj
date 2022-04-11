(ns basic.iteration.doseq-dotimes-mapv
(:use [clojure pprint]))

(def times [3 8 9 12 23 29 31 33 37 43 47 51 53 57])
(def persons ["Raze" "Reyna" "Jett"])

(defn sum-times [current-time]
   (let [empty-list (atom '())]

    (pprint (conj @empty-list 123))

    (pprint @empty-list)

    (swap! empty-list conj current-time)

    (pprint @empty-list)))

(defn add-persons [person]
    (let [database(atom '())]
          (swap! database conj person)
          ))

(defn test-mapv [current-time]
    (mapv #(sum-times %) current-time))

(test-mapv times)

(defn start-db [persons]
    (doseq[person persons]
                  (add-persons person)))

(start-db persons)
(test-mapv times)
