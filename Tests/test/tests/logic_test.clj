(ns tests.logic-test
  (:require [clojure.test :refer :all]
            [tests.logic.logic :refer :all]))

(deftest queue-size
  (testing "That empty list respect allowed max size on the queue")
    (is (fit-in-queue? {:wait []}, :wait))
  (testing "That people number don't respect allowed max size on the queue")
    (is (not (fit-in-queue? {:wait [1 2 3 4 5 6]}, :wait)))
  (testing "That people number respect allowed max size on the queue")
    (is (fit-in-queue? {:wait [1 2 3 4]}, :wait))
  (testing "That department exists")
    (is  (not  (fit-in-queue? {:wait [1]}, :x-ray)))
  )
