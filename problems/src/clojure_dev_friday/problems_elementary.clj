(ns clojure-dev-friday.problems-elementary
  (:require [clojure-dev-friday.core :refer [solve]]
            [clojure.test :refer [run-tests]]))

;; TAKEN FROM 4CLOJURE.COM

;; Problem 1:  Nothing but the Truth
;; This is a clojure form.  Enter a value which will make the form evaluate to true.  Don't over think it!
;; If you are confused, see the <a href='/directions'>getting started</a> page.  Hint: true is equal to true.
(def _p1
  ;;TODO your solution here
  false)

(solve problem1 
  (= _p1 true))

;; Problem 2:  Simple Math
;; <p>If you are not familiar with <a href='http://en.wikipedia.org/wiki/Polish_notation'>polish notation</a>,
;; simple arithmetic might seem confusing.</p><p><strong>Note:</strong> Enter only enough to fill in the blank
;; (in this case, a single number) - do not retype the whole problem.</p>
(def _p2
  ;;TODO your solution here
  4
  )

(solve problem2 
  (= (- 10 (* 2 3)) _p2))

;; Problem 3:  Intro to Strings
;; Clojure strings are Java strings.  This means that you can use any of the Java string methods on Clojure strings.
(def _p3
  ;;TODO your solution here
  )

(solve problem3 
  (= _p3 (.toUpperCase "hello world")))

;; Problem 4:  Intro to Lists
;; Lists can be constructed with either a function or a quoted form.
(def _p4
  (list :a :b :c))

(solve problem4 
  (= _p4 '(:a :b :c)))

;; Problem 5:  Lists: conj
;; When operating on a list, the conj function will return a new list with one or more items "added" to the front.
(def _p5
  ;;TODO your solution here
  [1 2 3 4])

(solve problem5 
  (= _p5 (conj '(2 3 4) 1))
  (= _p5 (conj '(3 4) 2 1)))

;; Problem 6:  Intro to Vectors
;; Vectors can be constructed several ways.  You can compare them with lists.
(def _p6
  [:a :b :c])

(solve problem6 
  (= _p6 (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))

;; Problem 7:  Vectors: conj
;; When operating on a Vector, the conj function will return a new vector with one or more items "added" to the end.
(def _p7
  ;;TODO your solution here
  (vector 1 2 3 4))

(solve problem7 
  (= _p7 (conj [1 2 3] 4))
  (= _p7 (conj [1 2] 3 4)))

;; Problem 8:  Intro to Sets
;; Sets are collections of unique values.
(def _p8
  ;;TODO your solution here
  )

(solve problem8 
  (= _p8 (set '(:a :a :b :c :c :c :c :d :d)))
  (= _p8 (clojure.set/union #{:a :b :c} #{:b :c :d})))

;; Problem 9:  Sets: conj
;; When operating on a set, the conj function returns a new set with one or more keys "added".
(def _p9
  ;;TODO your solution here
  )

(solve problem9 
  (= #{1 2 3 4} (conj #{1 4 3} _p9)))

;; Problem 10:  Intro to Maps
;; Maps store key-value pairs.  Both maps and keywords can be used as lookup functions. Commas can be used to make maps
;; more readable, but they are not required.
(def _p10
  ;;TODO your solution here
  )

(solve problem10 
  (= _p10 ((hash-map :a 10, :b 20, :c 30) :b))
  (= _p10 (:b {:a 10, :b 20, :c 30})))

;; Problem 11:  Maps: conj
;; When operating on a map, the conj function returns a new map with one or more key-value pairs "added".
(def _p11
  ;;TODO your solution here
  )

(solve problem11 
  (= {:a 1, :b 2, :c 3} (conj {:a 1} _p11 [:c 3])))

;; Problem 12:  Intro to Sequences
;; All Clojure collections support sequencing.  You can operate on sequences with functions like first, second, and last.
(def _p12
  ;;TODO your solution here
  )

(solve problem12 
  (= _p12 (first '(3 2 1)))
  (= _p12 (second [2 3 4]))
  (= _p12 (last (list 1 2 3))))

;; Problem 13:  Sequences: rest
;; The rest function will return all the items of a sequence except the first.
(def _p13
  ;;TODO your solution here
  )

(solve problem13 
  (= _p13 (rest [10 20 30 40])))

;; Problem 14:  Intro to Functions
;; Clojure has many different ways to create functions.
(def _p14
  ;;TODO your solution here
  )

(solve problem14 
  (= _p14 ((fn add-five [x] (+ x 5)) 3))
  (= _p14 ((fn [x] (+ x 5)) 3))
  (= _p14 (#(+ % 5) 3))
  (= _p14 ((partial + 5) 3)))

;; Problem 15:  Double Down
;; Write a function which doubles a number.
(def _p15
  ;;TODO your solution here
  )

(solve problem15 
  (= (_p15 2) 4)
  (= (_p15 3) 6)
  (= (_p15 11) 22)
  (= (_p15 7) 14))

;; Problem 16:  Hello World
;; Write a function which returns a personalized greeting.
(def _p16
  ;;TODO your solution here
  )

(solve problem16 
  (= (_p16 "Dave") "Hello, Dave!")
  (= (_p16 "Jenn") "Hello, Jenn!")
  (= (_p16 "Rhea") "Hello, Rhea!"))

;; Problem 17:  Sequences: map
;; The map function takes two arguments: a function (f) and a sequence (s).  Map returns a new sequence consisting of
;; the result of applying f to each item of s.  Do not confuse the map function with the map data structure.
(def _p17
  ;;TODO your solution here
  )

(solve problem17 
  (= _p17 (map #(+ % 5) '(1 2 3))))

;; Problem 18:  Sequences: filter
;; The filter function takes two arguments: a predicate function (f) and a sequence (s).  Filter returns a new
;; sequence consisting of all the items of s for which (f item) returns true.
(def _p18
  ;;TODO your solution here
  )

(solve problem18 
  (= _p18 (filter #(> % 5) '(3 4 5 6 7))))

;; Problem 35:  Local bindings
;; Clojure lets you give local names to values using the special let-form.
(def _p35
  ;;TODO your solution here
  )

(solve problem35 
  (= _p35 (let [x 5] (+ 2 x)))
  (= _p35 (let [x 3, y 10] (- y x)))
  (= _p35 (let [x 21] (let [y 3] (/ x y)))))

;; Problem 36:  Let it Be
;; Can you bind x, y, and z so that these are all true?
(def _p36
  ;;TODO your solution here
  )

(solve problem36 
  (= 10 (let _p36 (+ x y)))
  (= 4 (let _p36 (+ y z)))
  (= 1 (let _p36 z)))

;; Problem 37:  Regular Expressions
;; Regex patterns are supported with a special reader macro.
(def _p37
  ;;TODO your solution here
  )

(solve problem37 
  (= _p37 (apply str (re-seq #"[A-Z]+" "bA1B3Ce "))))

;; Problem 57:  Simple Recursion
;; A recursive function is a function which calls itself.  This is one of the fundamental techniques used
;; in functional programming.
(def _p57
  ;;TODO your solution here
  )

(solve problem57 
  (= _p57 ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)))

;; Problem 64:  Intro to Reduce
;; <a href='http://clojuredocs.org/clojure_core/clojure.core/reduce'>Reduce</a> takes a 2 argument function
;; and an optional starting value. It then applies the function to the first 2 items in the sequence (or the
;; starting value and the first element of the sequence). In the next iteration the function will be called
;; on the previous return value and the next item from the sequence, thus reducing the entire collection to one
;; value. Don't worry, it's not as complicated as it sounds.
(def _p64
  ;;TODO your solution here
  )

(solve problem64 
  (= 15 (reduce _p64 [1 2 3 4 5]))
  (=  0 (reduce _p64 []))
  (=  6 (reduce _p64 1 [2 3])))

;; Problem 68:  Recurring Theme
;; Clojure only has one non-stack-consuming looping construct: recur.  Either a function or a loop can be used
;; as the recursion point.  Either way, recur rebinds the bindings of the recursion point to the values it is passed.
;; Recur must be called from the tail-position, and calling it elsewhere will result in an error.
(def _p68
  ;;TODO your solution here
  )

(solve problem68 
  (= _p68
  (loop [x 5
         result []]
    (if (> x 0)
      (recur (dec x) (conj result (+ 2 x)))
      result))))

;; Problem 71:  Rearranging Code: ->
;; The -> macro threads an expression x through a variable number of forms. First, x is inserted as the second item
;; in the first form, making a list of it if it is not a list already.  Then the first form is inserted as the second
;; item in the second form, making a list of that form if necessary.  This process continues for all the forms.
;; Using -> can sometimes make your code more readable.
(def _p71
  ;;TODO your solution here
  )

(solve problem71 
  (= (_p71 (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (_p71))
   5))

;; Problem 72:  Rearranging Code: ->>
;; The ->> macro threads an expression x through a variable number of forms. First, x is inserted as the last item
;; in the first form, making a list of it if it is not a list already.  Then the first form is inserted as the last
;; item in the second form, making a list of that form if necessary.  This process continues for all the forms.
;; Using ->> can sometimes make your code more readable.
(def _p72
  ;;TODO your solution here
  )

(solve problem72 
  (= (_p72 (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (_p72))
   11))

;; Problem 134:  A nil key
;; Write a function which, given a key and map, returns true
;; <a href="http://en.wikipedia.org/wiki/If_and_only_if">iff</a> the map contains an entry with that key
;; and its value is nil.
(def _p134
  ;;TODO your solution here
  )

(solve problem134 
  (true?  (_p134 :a {:a nil :b 2}))
  (false? (_p134 :b {:a nil :b 2}))
  (false? (_p134 :c {:a nil :b 2})))

;; Problem 145:  For the win
;; Clojure's <a href="http://clojuredocs.org/clojure_core/clojure.core/for">for</a> macro is a tremendously versatile
;; mechanism for producing a sequence based on some other sequence(s). It can take some time to understand
;; how to use it properly, but that investment will be paid back with clear, concise sequence-wrangling later.
;; With that in mind, read over these <code>for</code> expressions and try to see how each of them produces the
;; same result.
(def _p145
  ;;TODO your solution here
  )

(solve problem145 
  (= _p145 (for [x (range 40)
            :when (= 1 (rem x 4))]
        x))
  (= _p145 (for [x (iterate #(+ 4 %) 0)
            :let [z (inc x)]
            :while (< z 40)]
        z))
  (= _p145 (for [[x y] (partition 2 (range 20))]
        (+ x y))))

;; Problem 156:  Map Defaults
;; When retrieving values from a map, you can specify default values in case the key is not found:
;; (= 2 (:foo {:bar 0, :baz 1} 2))
;; However, what if you want the map itself to contain the default values?  Write a function which takes a
;; default value and a sequence of keys and constructs a map.
(def _p156
  ;;TODO your solution here
  )

(solve problem156 
  (= (_p156 0 [:a :b :c]) {:a 0 :b 0 :c 0})
  (= (_p156 "x" [1 2 3]) {1 "x" 2 "x" 3 "x"})
  (= (_p156 [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]}))

