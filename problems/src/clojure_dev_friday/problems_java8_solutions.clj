(ns clojure-dev-friday.problems-java8-solutions
  (:import [java.time Period LocalDate])
  (:require [clojure.string :as str]
            [plumbing.core :refer [map-vals]]
            [clojure-dev-friday.core :refer [solve]]
            [clojure.test :refer [run-tests]]))


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

; How old is the oldest person in the given list.
(defn max-age [persons]
  (apply max (map get-persons-age persons)))


;* Build a comma-separated list of the firstnames of a list of Persons.
;* Example-Result: "Maggie, Marge, Mary"
(defn build-comma-separated-list-of-first-names [persons]
  (->> persons
       (map :first-name)
       (str/join ", ")))

(defn total-of-invoice [invoice]
  (->> invoice
       :items
       (map (fn [{:keys [price-per-unit quantity]}]
              (* price-per-unit quantity)))
       (reduce +)))

; Identify the cheapest product (by pricePerUnit) in all invoices.
(defn cheapest-product [invoices]
  (->> invoices
       (mapcat :items)
       (apply min-key :price-per-unit)
       (:product)))

; Identify the invoice with the highest total amount.
(defn most-expensive-invoice [invoices]
  (apply max-key total-of-invoice invoices))

(defn group-invoices-by-recipient [invoices]
  (group-by :recipient invoices))

; Compute the total amount, that each receiver spent.
(defn expenses-by-recipient [invoices]
  (->> invoices
       (group-by :recipient)
       (map (fn [[recipient invoices]]
              [recipient
               (reduce + (map total-of-invoice invoices))]))
       (into {})))

; How many items of each product have been purchased?
(defn count-by-product [invoices]
  (->> invoices
       (mapcat :items)
       (group-by :product)
       (map-vals (comp (partial reduce +)
                       (partial map :quantity)))))

; From a given list of invoices, compute for every dealer the available products together with its price.
(defn compute-dealer-inventory [invoices]
  (->> invoices
       (group-by :sender)
       (map-vals (fn [invoices-per-sender]
                   (->> invoices-per-sender
                        (mapcat :items)
                        (map #(select-keys % [:product :price-per-unit]))
                        (distinct))))))

; For every buyer, compute a list of his favorite products (that is: a list of products ordered by the total count
; of items bought).
; For example: Homer bought 5 beers at Moes, 2 beers and a burger at Crustys. Then the result should look like this:
; {"Homer" -> ["Beer", "Burger"]}
(defn favorite-articles-by-buyer [invoices]
  (->> invoices
       (group-by :recipient)
       (map-vals (fn [invoices-per-recipient]
                   (let [product->quantity
                         (->> invoices-per-recipient
                              (mapcat :items)
                              (map (juxt :product :quantity))
                              (reduce (fn [product->quantity [product quantity]]
                                        (update product->quantity product (fnil + 0) quantity))
                                      {}))]
                     (sort-by (comp - product->quantity) (keys product->quantity)))))))

; For every product, compute the cheapest dealer. Return as a Map where the key is the product name and the value
; is the dealer (=sender of the invoice).
(defn cheapest-dealers-by-product [invoices]
  (->> invoices
       (mapcat (fn [{:keys [items sender]}]
                     (map #(-> %
                               (select-keys [:product :price-per-unit])
                               (assoc :dealer sender)) items)))
       (group-by :product)
       (map-vals (fn [product-offers]
                   (:dealer (apply min-key :price-per-unit product-offers))))))



;;; filtering

(defn extract-names [persons]
  ;;(into [] (map (comp (partial str/join " ") (juxt :first-name :last-name))) persons)
  (map (fn [{:keys [first-name last-name]}]
         (str first-name " " last-name)) persons))

; Extract a sorted (ascending by lastname) list of names (firstname and lastname separated by space) from a given list of Person objects.
(defn extract-names-sorted-by-lastname [persons]
  (->> persons
       (sort-by :last-name)
       (map #(str (:first-name %) " " (:last-name %)))))

(defn extract-female-firstnames [persons]
  (sequence (comp (filter #(= :gender/female (:gender %))) (map :first-name)) persons))

(defn matching [k v]
  (fn [m]
    (= (get m k) v)))

(defn extract-adult-women [persons]
  (sequence (comp (filter (matching :gender :gender/female))
                  (filter #(> (get-persons-age %) 18)))
            persons))

(defn extract-firstnames-where-lastname-starts-with [persons prefix]
  (sequence (comp (filter (comp #(.startsWith % prefix) :last-name))
                  (map :first-name)) persons))

(defn extract-all-products [invoices]
  (into #{}
        (comp (mapcat :items) (map :product))
        invoices))
