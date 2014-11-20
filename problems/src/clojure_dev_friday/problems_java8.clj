(ns clojure-dev-friday.problems-java8
  (:import [java.time Period LocalDate])
  (:require [clojure.string :as str]
            [plumbing.core :refer [map-vals]]
            [clojure-dev-friday.core :refer [solve]]
            [clojure.test :refer [run-tests]]))

;; ADAPTED FROM https://github.com/codecentric/java8-examples

(defrecord Person [first-name last-name birthday gender])
(defrecord InvoiceItem [product quantity price-per-unit])
(defrecord Invoice [sender recipient items])

(defn get-years-since [date]
  (.getYears (Period/between date (LocalDate/now))))

(def get-persons-age
  (comp get-years-since :birthday))

(def test-data
  {:persons [(->Person "Jane" "Jungle" (LocalDate/of 1978 12 15) :gender/female)
             (->Person "Mary" "Smith" (LocalDate/of 1980 10 19) :gender/female)
             (->Person "John" "Dole" (LocalDate/of 1973 5 31) :gender/male)
             (->Person "Michael" "Abrahams" (LocalDate/of 1967 2 1) :gender/male)
             (->Person "Chris" "Cross" (LocalDate/of 1978 12 15) :gender/female)
             (->Person "Pete" "Power" (LocalDate/of 1981 3 18) :gender/male)
             (->Person "Maggie" "Simpson" (LocalDate/of 2012 10 18) :gender/female)]
   :invoices [(->Invoice "Crusty Burger" "Homer" [(->InvoiceItem "Burger" 5 5)
                                                  (->InvoiceItem "Coke" 1 5)])
              (->Invoice "Crusty Burger" "Bart" [(->InvoiceItem "Coke" 1 5)])
              (->Invoice "Moe" "Homer" [(->InvoiceItem "Beer" 13 1.5)
                                        (->InvoiceItem "Burger" 3 4.5)])
              (->Invoice "Kwik-E-Mart" "Homer" [(->InvoiceItem "Beer" 9 0.9)
                                                (->InvoiceItem "Chips" 2 0.5)])
              (->Invoice "Moe" "Marge" [(->InvoiceItem "Coke" 2 2.5)])
              (->Invoice "Kwik-E-Mart" "Bart" [(->InvoiceItem "Coke" 2 2.5)
                                               (->InvoiceItem "Chips" 2 0.5)])
              (->Invoice "Kwik-E-Mart" "Marge" [(->InvoiceItem "Cake" 2 3.4)
                                                (->InvoiceItem "Corn Flakes" 5 2.3)])
              (->Invoice "Moe" "Homer" [(->InvoiceItem "Beer" 5 1.5)])
              (->Invoice "Flander's Left-Handed Store" "Marge" [(->InvoiceItem "Left-Handed Scissors" 1 10)])]})

(def invoices (:invoices test-data))

(def persons (:persons test-data))

; max-age: How old is the oldest person in the persons list.
(def _p801
  ;; TODO
  )

(solve problem801
       (= 47 (_p801 persons)))

;* Build a comma-separated list of the firstnames of a list of Persons.
;* Example-Result: "Maggie, Marge, Mary"
(def _p802
  ;; TODO
  )

(solve problem802
       (= "Jane, Mary, John, Michael, Chris, Pete, Maggie" (_p802 persons)))

;; Total of invoice: Compute the total price of an invoice
(def _p803
  ;; TODO
  )

(solve problem803
       (= (_p803 (first invoices)) 30))

(def total-of-invoice _p803)

; cheapest-product: Identify the cheapest product (by pricePerUnit) in all invoices.
(def _p804
  ;; TODO
  )

(solve problem804
       (= (_p804 invoices)
          "Chips"))

; most-expensive-invoice: Identify the invoice with the highest total amount.
(def _p805
  ;; TODO
  )

(solve problem805
       (= (_p805 invoices)
          (->Invoice "Moe" "Homer" [(->InvoiceItem "Beer" 13 1.5)
                                    (->InvoiceItem "Burger" 3 4.5)])))

; Group invoices by recipients: return a map from recipient to his/her invoices
(def _p806
  ;; TODO
  )

(solve problem806
       (= (get (_p806 invoices) "Bart")
          [{:sender "Crusty Burger",
            :recipient "Bart",
            :items [{:product "Coke", :quantity 1, :price-per-unit 5}]}
           {:sender "Kwik-E-Mart",
            :recipient "Bart",
            :items
            [{:product "Coke", :quantity 2, :price-per-unit 2.5}
             {:product "Chips", :quantity 2, :price-per-unit 0.5}]}]))

; expenses-by-recipient: Compute the total amount, that each receiver spent.
(def _p807
  ;; TODO
  )

(solve problem807
       (= (_p807 invoices)
          {"Homer" 79.6, "Bart" 11.0, "Marge" 33.3}))

; count-by-product: How many items of each product have been purchased?
(def _p808
  ;; TODO

  )

(solve problem808
       (= (_p808 invoices)
          {"Burger" 8, "Coke" 6, "Beer" 27, "Chips" 4, "Cake" 2, "Corn Flakes" 5, "Left-Handed Scissors" 1}))

; compute-dealer-inventory: From a given list of invoices, compute for every dealer the available products together with its price.
(def _p809
  ;; TODO
  )

(solve problem809
       (= (_p809 invoices)
          {"Crusty Burger"               '({:price-per-unit 5, :product "Burger"} {:price-per-unit 5, :product "Coke"}),
           "Moe"                         '({:price-per-unit 1.5, :product "Beer"} {:price-per-unit 4.5, :product "Burger"} {:price-per-unit 2.5, :product "Coke"}),
           "Kwik-E-Mart"                 '({:price-per-unit 0.9, :product "Beer"} {:price-per-unit 0.5, :product "Chips"} {:price-per-unit 2.5, :product "Coke"} {:price-per-unit 3.4, :product "Cake"} {:price-per-unit 2.3, :product "Corn Flakes"}),
           "Flander's Left-Handed Store" '({:price-per-unit 10, :product "Left-Handed Scissors"})}))

; favorite-articles-by-buyer: For every buyer, compute a list of his favorite products (that is: a list of products ordered by the total count
; of items bought).
; For example: Homer bought 5 beers at Moes, 2 beers and a burger at Crustys. Then the result should look like this:
; {"Homer" -> ["Beer", "Burger"]}
(def _p810
  ;; TODO
  )

(solve problem810
       (= (_p810 invoices)
          {"Homer" ["Beer" "Burger" "Chips" "Coke"],
           "Marge" ["Corn Flakes" "Cake" "Coke" "Left-Handed Scissors"],
           "Bart" ["Coke" "Chips"]}))

; cheapest-dealers-by-product: For every product, compute the cheapest dealer. Return as a Map where the key is the product name and the value
; is the dealer (=sender of the invoice).
(def _p811
  ;; TODO
  )

(solve problem811
       (= (_p811 invoices)
          {"Burger" "Moe",
           "Coke" "Kwik-E-Mart",
           "Beer" "Kwik-E-Mart",
           "Chips" "Kwik-E-Mart",
           "Cake" "Kwik-E-Mart",
           "Corn Flakes" "Kwik-E-Mart",
           "Left-Handed Scissors" "Flander's Left-Handed Store"}))


;;; filtering

(defn matching [k v]
  (fn [m]
    (= (get m k) v)))

; extract-names: Extract the persons name as concatenation of first-name and last-name.
(def _p812
  ;; TODO
  )

(solve problem812
       (= (_p812 persons)
          '("Jane Jungle" "Mary Smith" "John Dole" "Michael Abrahams" "Chris Cross" "Pete Power" "Maggie Simpson")))

; extract-names-sorted-by-lastname: Extract a sorted (ascending by lastname) list of names (firstname and lastname separated by space) from a given list of Person objects.
(def _p813
  ;; TODO
  )

(solve problem813
       (= (_p813 persons)
          '("Michael Abrahams" "Chris Cross" "John Dole" "Jane Jungle" "Pete Power" "Maggie Simpson" "Mary Smith")))

; extract-female-firstnames: Extract the firstnames of all females
(def _p814
  ;; TODO
  )

(solve problem814
       (= (_p814 persons)
          ["Jane" "Mary" "Chris" "Maggie"]))

;; extract-adult-women: Filter out females that are 18+
(def _p815
  ;; TODO
  )

(solve problem815
       (= (_p815 persons)
          [{:first-name "Jane",
            :last-name  "Jungle",
            :birthday (LocalDate/of 1978 12 15),
            :gender     :gender/female}
           {:first-name "Mary",
            :last-name  "Smith",
            :birthday (LocalDate/of 1980 10 19),
            :gender     :gender/female}
           {:first-name "Chris",
            :last-name  "Cross",
            :birthday (LocalDate/of 1978 12 15),
            :gender     :gender/female}]))

; extract-firstnames-where-lastname-starts-with: Filter firstnames of persons whose lastname starts with the given prefix
(def _p816
  ;; TODO
  )

(solve problem816
       (= (_p816 persons "S")
          '("Mary" "Maggie")))

; extract-all-products: Extract the set of all products across all invoices
(def _p817
  ;; TODO
  )

(solve problem817
       (= (_p817 invoices)
          #{"Left-Handed Scissors" "Coke" "Chips" "Beer" "Burger" "Corn Flakes" "Cake"}))

