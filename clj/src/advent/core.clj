(ns advent.core
  (:require [clojure.java.io :as io]))

(defn day1-find-mult
  [target-sum inputs]
  (loop [[x & xs] inputs]
    (when-not (nil? x)
      (let [y (first (filter #(= target-sum (+ x %)) xs))]
        (if-not (nil? y)
          (* x y)
          (recur xs))))))

(comment
  (with-open [day1 (io/reader "/home/auclair/code/perso/advent2020/day1/input.txt")]
    (def day1-input (into [] (map #(Integer/parseInt %) (line-seq day1) ))))

  (day1-find-mult 2020 day1-input)
  ;; => 1020099

  (count day1-input)

  (loop [[x & xs] day1-input]
    (when-not (nil? x)
      (let [mult (day1-find-mult (- 2020 x) xs)]
        (if-not (nil? mult)
          (* x mult)
          (recur xs)))))
  ;; => 9214880
  )
