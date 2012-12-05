;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we
;; can see that the 6th prime is 13.
;; What is the 10 001st prime number?

(defn factor-of? [f n]
  (zero? (rem n f)))

(defn prime? [n]
  (not-any? #(factor-of? % n) (range 2 (Math/sqrt n))))

(def primes
  (filter prime? (iterate inc 1)))

(nth 10000 primes)

