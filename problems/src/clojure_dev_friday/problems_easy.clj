(ns clojure-dev-friday.problems-easy
  (:require [clojure-dev-friday.core :refer [solve]]
            [clojure.test :refer [run-tests]]))

;; TAKEN FROM 4CLOJURE.COM

;; Problem 19:  Last Element
;; Write a function which returns the last element in a sequence.
(def _p19
  ;;TODO your solution here
  last)

(solve problem19 
  (= (_p19 [1 2 3 4 5]) 5)
  (= (_p19 '(5 4 3)) 3)
  (= (_p19 ["b" "c" "d"]) "d"))

;; Problem 20:  Penultimate Element
;; Write a function which returns the second to last element from a sequence.
(def _p20
  ;;TODO your solution here
  )

(solve problem20 
  (= (_p20 (list 1 2 3 4 5)) 4)
  (= (_p20 ["a" "b" "c"]) "b")
  (= (_p20 [[1 2] [3 4]]) [1 2]))

;; Problem 21:  Nth Element
;; Write a function which returns the Nth element from a sequence.
(def _p21
  ;;TODO your solution here
  )

(solve problem21 
  (= (_p21 '(4 5 6 7) 2) 6)
  (= (_p21 [:a :b :c] 0) :a)
  (= (_p21 [1 2 3 4] 1) 2)
  (= (_p21 '([1 2] [3 4] [5 6]) 2) [5 6]))

;; Problem 22:  Count a Sequence
;; Write a function which returns the total number of elements in a sequence.
(def _p22
  ;;TODO your solution here
  )

(solve problem22 
  (= (_p22 '(1 2 3 3 1)) 5)
  (= (_p22 "Hello World") 11)
  (= (_p22 [[1 2] [3 4] [5 6]]) 3)
  (= (_p22 '(13)) 1)
  (= (_p22 '(:a :b :c)) 3))

;; Problem 23:  Reverse a Sequence
;; Write a function which reverses a sequence.
(def _p23
  ;;TODO your solution here
  )

(solve problem23 
  (= (_p23 [1 2 3 4 5]) [5 4 3 2 1])
  (= (_p23 (sorted-set 5 7 2 7)) '(7 5 2))
  (= (_p23 [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))

;; Problem 24:  Sum It All Up
;; Write a function which returns the sum of a sequence of numbers.
(def _p24
  ;;TODO your solution here
  )

(solve problem24 
  (= (_p24 [1 2 3]) 6)
  (= (_p24 (list 0 -2 5 5)) 8)
  (= (_p24 #{4 2 1}) 7)
  (= (_p24 '(0 0 -1)) -1)
  (= (_p24 '(1 10 3)) 14))

;; Problem 25:  Find the odd numbers
;; Write a function which returns only the odd numbers from a sequence.
(def _p25
  ;;TODO your solution here
  )

(solve problem25 
  (= (_p25 #{1 2 3 4 5}) '(1 3 5))
  (= (_p25 [4 2 1 6]) '(1))
  (= (_p25 [2 2 4 6]) '())
  (= (_p25 [1 1 1 3]) '(1 1 1 3)))

;; Problem 26:  Fibonacci Sequence
;; Write a function which returns the first X fibonacci numbers.
(def _p26
  ;;TODO your solution here
  )

(solve problem26 
  (= (_p26 3) '(1 1 2))
  (= (_p26 6) '(1 1 2 3 5 8))
  (= (_p26 8) '(1 1 2 3 5 8 13 21)))

;; Problem 27:  Palindrome Detector
;; Write a function which returns true if the given sequence is a palindrome.<br/><br>
;;                Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)
(def _p27
  ;;TODO your solution here
  )

(solve problem27 
  (false? (_p27 '(1 2 3 4 5)))
  (true? (_p27 "racecar"))
  (true? (_p27 [:foo :bar :foo]))
  (true? (_p27 '(1 1 3 3 1 1)))
  (false? (_p27 '(:a :b :c))))

;; Problem 28:  Flatten a Sequence
;; Write a function which flattens a sequence.
(def _p28
  ;;TODO your solution here
  )

(solve problem28 
  (= (_p28 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
  (= (_p28 ["a" ["b"] "c"]) '("a" "b" "c"))
  (= (_p28 '((((:a))))) '(:a)))

;; Problem 29:  Get the Caps
;; Write a function which takes a string and returns a new string containing only the capital letters.
(def _p29
  ;;TODO your solution here
  )

(solve problem29 
  (= (_p29 "HeLlO, WoRlD!") "HLOWRD")
  (empty? (_p29 "nothing"))
  (= (_p29 "$#A(*&987Zf") "AZ"))

;; Problem 30:  Compress a Sequence
;; Write a function which removes consecutive duplicates from a sequence.
(def _p30
  ;;TODO your solution here
  )

(solve problem30 
  (= (apply str (_p30 "Leeeeeerrroyyy")) "Leroy")
  (= (_p30 [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
  (= (_p30 [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))

;; Problem 31:  Pack a Sequence
;; Write a function which packs consecutive duplicates into sub-lists.
(def _p31
  ;;TODO your solution here
  )

(solve problem31 
  (= (_p31 [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
  (= (_p31 [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
  (= (_p31 [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))

;; Problem 32:  Duplicate a Sequence
;; Write a function which duplicates each element of a sequence.
(def _p32
  ;;TODO your solution here
  )

(solve problem32 
  (= (_p32 [1 2 3]) '(1 1 2 2 3 3))
  (= (_p32 [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
  (= (_p32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
  (= (_p32 [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))

;; Problem 33:  Replicate a Sequence
;; Write a function which replicates each element of a sequence a variable number of times.
(def _p33
  ;;TODO your solution here
  )

(solve problem33 
  (= (_p33 [1 2 3] 2) '(1 1 2 2 3 3))
  (= (_p33 [:a :b] 4) '(:a :a :a :a :b :b :b :b))
  (= (_p33 [4 5 6] 1) '(4 5 6))
  (= (_p33 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
  (= (_p33 [44 33] 2) [44 44 33 33]))

;; Problem 34:  Implement range
;; Write a function which creates a list of all integers in a given range.
(def _p34
  ;;TODO your solution here
  )

(solve problem34 
  (= (_p34 1 4) '(1 2 3))
  (= (_p34 -2 2) '(-2 -1 0 1))
  (= (_p34 5 8) '(5 6 7)))

;; Problem 38:  Maximum value
;; Write a function which takes a variable number of parameters and returns the maximum value.
(def _p38
  ;;TODO your solution here
  )

(solve problem38 
  (= (_p38 1 8 3 4) 8)
  (= (_p38 30 20) 30)
  (= (_p38 45 67 11) 67))

;; Problem 39:  Interleave Two Seqs
;; Write a function which takes two sequences and returns the first item from each, then the second item from each,
;; then the third, etc.
(def _p39
  ;;TODO your solution here
  )

(solve problem39 
  (= (_p39 [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
  (= (_p39 [1 2] [3 4 5 6]) '(1 3 2 4))
  (= (_p39 [1 2 3 4] [5]) [1 5])
  (= (_p39 [30 20] [25 15]) [30 25 20 15]))

;; Problem 40:  Interpose a Seq
;; Write a function which separates the items of a sequence by an arbitrary value.
(def _p40
  ;;TODO your solution here
  )

(solve problem40 
  (= (_p40 0 [1 2 3]) [1 0 2 0 3])
  (= (apply str (_p40 ", " ["one" "two" "three"])) "one, two, three")
  (= (_p40 :z [:a :b :c :d]) [:a :z :b :z :c :z :d]))

;; Problem 41:  Drop Every Nth Item
;; Write a function which drops every Nth item from a sequence.
(def _p41
  ;;TODO your solution here
  )

(solve problem41 
  (= (_p41 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
  (= (_p41 [:a :b :c :d :e :f] 2) [:a :c :e])
  (= (_p41 [1 2 3 4 5 6] 4) [1 2 3 5 6]))

;; Problem 42:  Factorial Fun
;; Write a function which calculates factorials.
(def _p42
  ;;TODO your solution here
  )

(solve problem42 
  (= (_p42 1) 1)
  (= (_p42 3) 6)
  (= (_p42 5) 120)
  (= (_p42 8) 40320))

;; Problem 45:  Intro to Iterate
;; The iterate function can be used to produce an infinite lazy sequence.
(def _p45
  ;;TODO your solution here
  )

(solve problem45 
  (= _p45 (take 5 (iterate #(+ 3 %) 1))))

;; Problem 47:  Contain Yourself
;; The contains? function checks if a KEY is present in a given collection.  This often leads beginner
;; clojurians to use it incorrectly with numerically indexed collections like vectors and lists.
(def _p47
  ;;TODO your solution here
  )

(solve problem47 
  (contains? #{4 5 6} _p47)
  (contains? [1 1 1 1 1] _p47)
  (contains? {4 :a 2 :b} _p47)
  (not (contains? '(1 2 4) _p47)))

;; Problem 48:  Intro to some
;; The some function takes a predicate function and a collection.  It returns the first logical true value
;; of (predicate x) where x is an item in the collection.
(def _p48
  ;;TODO your solution here
  )

(solve problem48 
  (= _p48 (some #{2 7 6} [5 6 7 8]))
  (= _p48 (some #(when (even? %) %) [5 6 7 8])))

;; Problem 49:  Split a sequence
;; Write a function which will split a sequence into two parts.
(def _p49
  ;;TODO your solution here
  )

(solve problem49 
  (= (_p49 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
  (= (_p49 1 [:a :b :c :d]) [[:a] [:b :c :d]])
  (= (_p49 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]))

;; Problem 51:  Advanced Destructuring
;; Here is an example of some more sophisticated destructuring.
(def _p51
  ;;TODO your solution here
  )

(solve problem51 
  (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] _p51] [a b c d])))

;; Problem 52:  Intro to Destructuring
;; Let bindings and function parameter lists support destructuring.
(def _p52
  ;;TODO your solution here
  )

(solve problem52 
  (= [2 4] (let [[a b c d e f g] (range)] _p52)))

;; Problem 61:  Map Construction
;; Write a function which takes a vector of keys and a vector of values and constructs a map from them.
(def _p61
  ;;TODO your solution here
  )

(solve problem61 
  (= (_p61 [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
  (= (_p61 [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
  (= (_p61 [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}))

;; Problem 62:  Re-implement Iterate
;; Given a side-effect free function f and an initial value x write a function which returns an infinite
;; lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc.
(def _p62
  ;;TODO your solution here
  )

(solve problem62 
  (= (take 5 (_p62 #(* 2 %) 1)) [1 2 4 8 16])
  (= (take 100 (_p62 inc 0)) (take 100 (range)))
  (= (take 9 (_p62 #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))))

;; Problem 63:  Group a Sequence
;; Given a function f and a sequence s, write a function which returns a map.  The keys should be the values
;; of f applied to each item in s.  The value at each key should be a vector of corresponding items in the order
;; they appear in s.
(def _p63
  ;;TODO your solution here
  )

(solve problem63 
  (= (_p63 #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
  (= (_p63 #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
  (= (_p63 count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}))

;; Problem 66:  Greatest Common Divisor
;; Given two integers, write a function which
;;returns the greatest common divisor.
(def _p66
  ;;TODO your solution here
  )

(solve problem66 
  (= (_p66 2 4) 2)
  (= (_p66 10 5) 5)
  (= (_p66 5 7) 1)
  (= (_p66 1023 858) 33))

;; Problem 81:  Set Intersection
;; Write a function which returns the intersection of two sets.  The intersection is the sub-set of items that each
;; set has in common.
(def _p81
  ;;TODO your solution here
  )

(solve problem81 
  (= (_p81 #{0 1 2 3} #{2 3 4 5}) #{2 3})
  (= (_p81 #{0 1 2} #{3 4 5}) #{})
  (= (_p81 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))

;; Problem 83:  A Half-Truth
;; Write a function which takes a variable number of booleans.  Your function should return true if some of the
;; parameters are true, but not all of the parameters are true.  Otherwise your function should return false.
(def _p83
  ;;TODO your solution here
  )

(solve problem83 
  (= false (_p83 false false))
  (= true (_p83 true false))
  (= false (_p83 true))
  (= true (_p83 false true false))
  (= false (_p83 true true true))
  (= true (_p83 true true true false)))

;; Problem 88:  Symmetric Difference
;; Write a function which returns the symmetric difference of two sets.  The symmetric difference is the set of
;; items belonging to one but not both of the two sets.
(def _p88
  ;;TODO your solution here
  )

(solve problem88 
  (= (_p88 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
  (= (_p88 #{:a :b :c} #{}) #{:a :b :c})
  (= (_p88 #{} #{4 5 6}) #{4 5 6})
  (= (_p88 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}))

;; Problem 90:  Cartesian Product
;; Write a function which calculates the <a href="http://en.wikipedia.org/wiki/Cartesian_product"> Cartesian product</a>
;; of two sets.
(def _p90
  ;;TODO your solution here
  )

(solve problem90 
  (= (_p90 #{"ace" "king" "queen"} #{"&#9824;" "&#9829;" "&#9830;" "&#9827;"})
   #{["ace"   "&#9824;"] ["ace"   "&#9829;"] ["ace"   "&#9830;"] ["ace"   "&#9827;"]
     ["king"  "&#9824;"] ["king"  "&#9829;"] ["king"  "&#9830;"] ["king"  "&#9827;"]
     ["queen" "&#9824;"] ["queen" "&#9829;"] ["queen" "&#9830;"] ["queen" "&#9827;"]})
  (= (_p90 #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})
  (= 300 (count (_p90 (into #{} (range 10))
                  (into #{} (range 30))))))

;; Problem 95:  To Tree, or not to Tree
;; Write a predicate which checks whether or not a given sequence represents a
;; <a href="http://en.wikipedia.org/wiki/Binary_tree">binary tree</a>.  Each node in the tree must have a value,
;; a left child, and a right child.
(def _p95
  ;;TODO your solution here
  )

(solve problem95 
  (= (_p95 '(:a (:b nil nil) nil))
   true)
  (= (_p95 '(:a (:b nil nil)))
   false)
  (= (_p95 [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)
  (= (_p95 [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)
  (= (_p95 [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)
  (= (_p95 [1 [2 [3 [4 false nil] nil] nil] nil])
   false)
  (= (_p95 '(:a nil ()))
   false)
)

;; Problem 96:  Beauty is Symmetry
;; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right
;; half of the tree.  Write a predicate to determine whether or not a given binary tree is symmetric.
;; (see <a href='/problem/95'>To Tree, or not to Tree</a> for a reminder on the tree representation we're using).
(def _p96
  ;;TODO your solution here
  )

(solve problem96 
  (= (_p96 '(:a (:b nil nil) (:b nil nil))) true)
  (= (_p96 '(:a (:b nil nil) nil)) false)
  (= (_p96 '(:a (:b nil nil) (:c nil nil))) false)
  (= (_p96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)
  (= (_p96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)
  (= (_p96 [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false))

;; Problem 97:  Pascal's Triangle
;; <a href="http://en.wikipedia.org/wiki/Pascal%27s_triangle">Pascal's triangle</a> is a triangle of numbers
;; computed using the following rules:<br/></br>- The first row is 1.</br>- Each successive row is computed by
;; adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.<br/><br/>
;; Write a function which returns the nth row of Pascal's Triangle.



(def _p97
  ;;TODO your solution here
  )

(solve problem97 
  (= (_p97 1) [1])
  (= (map _p97 (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])
  (= (_p97 11)
   [1 10 45 120 210 252 210 120 45 10 1]))

;; Problem 99:  Product Digits
;; Write a function which multiplies two numbers and returns the result as a sequence of its digits.
(def _p99
  ;;TODO your solution here
  )

(solve problem99 
  (= (_p99 1 1) [1])
  (= (_p99 99 9) [8 9 1])
  (= (_p99 999 99) [9 8 9 0 1]))

;; Problem 100:  Least Common Multiple
;; Write a function which calculates the
;; <a href="http://en.wikipedia.org/wiki/Least_common_multiple">least common multiple</a>.  Your function
;; should accept a variable number of positive integers or ratios.
(def _p100
  ;;TODO your solution here
  )

(solve problem100 
  (== (_p100 2 3) 6)
  (== (_p100 5 3 7) 105)
  (== (_p100 1/3 2/5) 2)
  (== (_p100 3/4 1/6) 3/2)
  (== (_p100 7 5/7 2 3/5) 210))

;; Problem 107:  Simple closures
;; <p>Lexical scope and first-class functions are two of the most basic building blocks of a functional
;; language like Clojure. When you combine the two together, you get something very powerful called
;; <strong>lexical closures</strong>. With these, you can exercise a great deal of control over the
;; lifetime of your local bindings, saving their values for use later, long after the code you're running now has finished.</p>
;;
;;<p>It can be hard to follow in the abstract, so let's build a simple closure. Given a positive integer
;; <i>n</i>, return a function <code>(f x)</code> which computes <i>x<sup>n</sup></i>. Observe that the
;; effect of this is to preserve the value of <i>n</i> for use outside the scope in which it is defined.</p>
(def _p107
  ;;TODO your solution here
  )

(solve problem107 
  (= 256 ((_p107 2) 16),
       ((_p107 8) 2))
  (= [1 8 27 64] (map (_p107 3) [1 2 3 4]))
  (= [1 2 4 8 16] (map #((_p107 %) 2) [0 1 2 3 4])))

;; Problem 118:  Re-implement Map
;; <p>Map is one of the core elements of a functional programming language. Given a function
;; <code>f</code> and an input sequence <code>s</code>, return a lazy sequence of <code>(f x)</code> for
;; each element <code>x</code> in <code>s</code>.
(def _p118
  ;;TODO your solution here
  )

(solve problem118 
  (= [3 4 5 6 7]
   (_p118 inc [2 3 4 5 6]))
  (= (repeat 10 nil)
   (_p118 (fn [_] nil) (range 10)))
  (= [1000000 1000001]
   (->> (_p118 inc (range))
        (drop (dec 1000000))
        (take 2))))

;; Problem 120:  Sum of square of digits
;; Write a function which takes a collection of integers as an argument.  Return the count of how many
;; elements are smaller than the sum of their squared component digits.  For example: 10 is larger than
;; 1 squared plus 0 squared; whereas 15 is smaller than 1 squared plus 5 squared.
(def _p120
  ;;TODO your solution here
  )

(solve problem120 
  (= 8 (_p120 (range 10)))
  (= 19 (_p120 (range 30)))
  (= 50 (_p120 (range 100)))
  (= 50 (_p120 (range 1000))))

;; Problem 122:  Read a binary number
;; Convert a binary number, provided in the form of a string, to its numerical value.
(def _p122
  ;;TODO your solution here
  )

(solve problem122 
  (= 0     (_p122 "0"))
  (= 7     (_p122 "111"))
  (= 8     (_p122 "1000"))
  (= 9     (_p122 "1001"))
  (= 255   (_p122 "11111111"))
  (= 1365  (_p122 "10101010101"))
  (= 65535 (_p122 "1111111111111111")))

;; Problem 126:  Through the Looking Class
;; Enter a value which satisfies the following:
(def _p126
  ;;TODO your solution here
  )

(solve problem126 
  (let [x _p126]
  (and (= (class x) x) x)))

;; Problem 128:  Recognize Playing Cards
;; <p>A standard American deck of playing cards has four suits - spades, hearts, diamonds, and clubs -
;; and thirteen cards in each suit. Two is the lowest rank, followed by other integers up to ten; then
;; the jack, queen, king, and ace.</p>
;
;<p>It's convenient for humans to represent these cards as suit/rank pairs, such as H5 or DQ: the heart
; five and diamond queen respectively. But these forms are not convenient for programmers, so to write a
; card game you need some way to parse an input string into meaningful components. For purposes of
; determining rank, we will define the cards to be valued from 0 (the two) to 12 (the ace)</p>
;
;<p>Write a function which converts (for example) the string "SJ" into a map of <code>{:suit :spade, :rank 9}
; </code>. A ten will always be represented with the single character "T", rather than the two characters "10".</p>
(def _p128
  ;;TODO your solution here
  )

(solve problem128 
  (= {:suit :diamond :rank 10} (_p128 "DQ"))
  (= {:suit :heart :rank 3} (_p128 "H5"))
  (= {:suit :club :rank 12} (_p128 "CA"))
  (= (range 13) (map (comp :rank _p128 str)
                   '[S2 S3 S4 S5 S6 S7
                     S8 S9 ST SJ SQ SK SA])))

;; Problem 135:  Infix Calculator
;; Your friend Joe is always whining about Lisps using the prefix notation for math. Show him
;; how you could easily write a function that does math using the infix notation. Is your favorite
;; language that flexible, Joe?
;
;Write a function that accepts a variable length mathematical expression consisting of numbers and the
; operations +, -, *, and /. Assume a simple calculator that does not do precedence and instead just calculates left to right.
(def _p135
  ;;TODO your solution here
  )

(solve problem135 
  (= 7  (_p135 2 + 5))
  (= 42 (_p135 38 + 48 - 2 / 2))
  (= 8  (_p135 10 / 2 - 1 * 2))
  (= 72 (_p135 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)))

;; Problem 143:  dot product
;; Create a function that computes the <a href="http://en.wikipedia.org/wiki/Dot_product#Definition">dot product</a> of two sequences. You may assume that the vectors will have the same length.
(def _p143
  ;;TODO your solution here
  )

(solve problem143 
  (= 0 (_p143 [0 1 0] [1 0 0]))
  (= 3 (_p143 [1 1 1] [1 1 1]))
  (= 32 (_p143 [1 2 3] [4 5 6]))
  (= 256 (_p143 [2 5 6] [100 10 1])))

;; Problem 146:  Trees into tables
;; <p>Because Clojure's <code>for</code> macro allows you to "walk" over multiple sequences in a nested fashion, it is excellent for transforming all sorts of sequences. If you don't want a sequence as your final output (say you want a map), you are often still best-off using <code>for</code>, because you can produce a sequence and feed it into a map, for example.</p>
;
;<p>For this problem, your goal is to "flatten" a map of hashmaps. Each key in your output map should be the "path"<sup>1</sup> that you would have to take in the original map to get to a value, so for example <code>{1 {2 3}}</code> should result in <code>{[1 2] 3}</code>. You only need to flatten one level of maps: if one of the values is a map, just leave it alone.</p>
;
;<p><sup>1</sup> That is, <code>(get-in original [k1 k2])</code> should be the same as <code>(get result [k1 k2])</code></p>
(def _p146
  ;;TODO your solution here
  )

(solve problem146 
  (= (_p146 '{a {p 1, q 2}
         b {m 3, n 4}})
   '{[a p] 1, [a q] 2
     [b m] 3, [b n] 4})
  (= (_p146 '{[1] {a b c d}
         [2] {q r s t u v w x}})
   '{[[1] a] b, [[1] c] d,
     [[2] q] r, [[2] s] t,
     [[2] u] v, [[2] w] x})
  (= (_p146 '{m {1 [a b c] 3 nil}})
   '{[m 1] [a b c], [m 3] nil}))

;; Problem 147:  Pascal's Trapezoid
;; <p>Write a function that, for any given input vector of numbers, returns an infinite lazy sequence of vectors, where each next one is constructed from the previous following the rules used in <a href="http://en.wikipedia.org/wiki/Pascal's_triangle">Pascal's Triangle</a>. For example, for [3 1 2], the next row is [3 4 3 2].</p>
;;<p>Beware of arithmetic overflow! In clojure (since version 1.3 in 2011), if you use an arithmetic operator like + and the result is too large to fit into a 64-bit integer, an exception is thrown. You can use +' to indicate that you would rather overflow into Clojure's slower, arbitrary-precision bigint.</p>
(def _p147
  ;;TODO your solution here
  )

(solve problem147 
  (= (second (_p147 [2 3 2])) [2 5 5 2])
  (= (take 5 (_p147 [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
  (= (take 2 (_p147 [3 1 2])) [[3 1 2] [3 4 3 2]])
  (= (take 100 (_p147 [2 4 2])) (rest (take 101 (_p147 [2 2])))))

;; Problem 153:  Pairwise Disjoint Sets
;; 
;<p>
;Given a set of sets, create a function which returns <code>true</code>
;if no two of those sets have any elements in common<sup>1</sup> and <code>false</code> otherwise.
;Some of the test cases are a bit tricky, so pay a little more attention to them.
;</p>
;
;<p>
;<sup>1</sup>Such sets are usually called <i>pairwise disjoint</i> or <i>mutually disjoint</i>.
;</p>

(def _p153
  ;;TODO your solution here
  )

(solve problem153 
  (= (_p153 #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
   true)
  (= (_p153 #{#{:a :b :c :d :e}
         #{:a :b :c :d}
         #{:a :b :c}
         #{:a :b}
         #{:a}})
   false)
  (= (_p153 #{#{[1 2 3] [4 5]}
         #{[1 2] [3 4 5]}
         #{[1] [2] 3 4 5}
         #{1 2 [3 4] [5]}})
   true)
  (= (_p153 #{#{'a 'b}
         #{'c 'd 'e}
         #{'f 'g 'h 'i}
         #{''a ''c ''f}})
   true)
  (= (_p153 #{#{'(:x :y :z) '(:x :y) '(:z) '()}
         #{#{:x :y :z} #{:x :y} #{:z} #{}}
         #{'[:x :y :z] [:x :y] [:z] [] {}}})
   false)
  (= (_p153 #{#{(= "true") false}
         #{:yes :no}
         #{(class 1) 0}
         #{(symbol "true") 'false}
         #{(keyword "yes") ::no}
         #{(class '1) (int \0)}})
   false)
  (= (_p153 #{#{distinct?}
         #{#(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}})
   true)
  (= (_p153 #{#{(#(-> *)) + (quote mapcat) #_ nil}
         #{'+ '* mapcat (comment mapcat)}
         #{(do) set contains? nil?}
         #{, , , #_, , empty?}})
   false))

;; Problem 157:  Indexing Sequences
;; Transform a sequence into a sequence of pairs containing the original elements along with their index.
(def _p157
  ;;TODO your solution here
  )

(solve problem157 
  (= (_p157 [:a :b :c]) [[:a 0] [:b 1] [:c 2]])
  (= (_p157 [0 1 3]) '((0 0) (1 1) (3 2)))
  (= (_p157 [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]))

