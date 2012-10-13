;; 2520 is the smallest number that can be divided by each of the
;; numbers from 1 to 10 without any remainder.
;; What is the smallest positive number that is evenly divisible by
;; all of the numbers from 1 to 20?

(def dividers
  (filter #(> % (/ 20 2)) (range 1 21)))

(defn inc-twenty [n]
  "Add 20 to passed number"
  (+ 20 n))

(defn divided-by-all [n]
  "Check if passed number can be devided by all numbers from 1 to 20
without reminder"
  (every? #(zero? (rem n %)) dividers))

;; Test against only for multiplies of 20
(time (first (filter divided-by-all (iterate inc-twenty 20))))

