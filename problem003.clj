;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn is-div? [number div]
  (zero? (rem number div)))

(defn primes [range-end]
  "Sieve of Erastotenes."
  (loop [factor 2 rng (range 2 range-end)]
    (if (> factor (Math/sqrt range-end))
      rng
      (let [new-rng (remove #(and (> % factor) (is-div? % factor)) rng)
            new-factor (first (filter #(> % factor) new-rng))]
        (recur new-factor new-rng)))))

(defn largest-factor [n]
  "Find largest factor of n. Uses Sieve of Erastotenes."
  (last (filter #(is-div? n %) (primes (Math/sqrt n)))))

(println (largest-factor 600851475143))