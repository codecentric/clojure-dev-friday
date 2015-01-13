(ns clojure-dev-friday.problems-normal
  (:require [clojure-dev-friday.core :refer [solve]]
            [clojure.test :refer [run-tests]]))

;; TAKEN FROM 4CLOJURE.COM

;; Problem 43:  Reverse Interleave
;; Write a function which reverses the interleave process into x number of subsequences.
(def _p43
  ;;TODO your solution here
  )

(solve problem43 
  (= (_p43 [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
  (= (_p43 (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
  (= (_p43 (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))

;; Problem 44:  Rotate Sequence
;; Write a function which can rotate a sequence in either direction.
(def _p44
  ;;TODO your solution here
  )

(solve problem44 
  (= (_p44 2 [1 2 3 4 5]) '(3 4 5 1 2))
  (= (_p44 -2 [1 2 3 4 5]) '(4 5 1 2 3))
  (= (_p44 6 [1 2 3 4 5]) '(2 3 4 5 1))
  (= (_p44 1 '(:a :b :c)) '(:b :c :a))
  (= (_p44 -4 '(:a :b :c)) '(:c :a :b)))

;; Problem 46:  Flipping out
;; Write a higher-order function which flips the order of the arguments of an input function.
(def _p46
  ;;TODO your solution here
  )

(solve problem46 
  (= 3 ((_p46 nth) 2 [1 2 3 4 5]))
  (= true ((_p46 >) 7 8))
  (= 4 ((_p46 quot) 2 8))
  (= [1 2 3] ((_p46 take) [1 2 3 4 5] 3)))

;; Problem 50:  Split by Type
;; Write a function which takes a sequence consisting of items with different types and splits them up into a set of homogeneous sub-sequences. The internal order of each sub-sequence should be maintained, but the sub-sequences themselves can be returned in any order (this is why 'set' is used in the test cases).
(def _p50
  ;;TODO your solution here
  )

(solve problem50 
  (= (set (_p50 [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
  (= (set (_p50 [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]})
  (= (set (_p50 [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))

;; Problem 54:  Partition a Sequence
;; Write a function which returns a sequence of lists of x items each.  Lists of less than x items should not be returned.
(def _p54
  ;;TODO your solution here
  )

(solve problem54 
  (= (_p54 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
  (= (_p54 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
  (= (_p54 3 (range 8)) '((0 1 2) (3 4 5))))

;; Problem 55:  Count Occurrences
;; Write a function which returns a map containing the number of occurences of each distinct item in a sequence.
(def _p55
  ;;TODO your solution here
  )

(solve problem55 
  (= (_p55 [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
  (= (_p55 [:b :a :b :a :b]) {:a 2, :b 3})
  (= (_p55 '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))

;; Problem 56:  Find Distinct Items
;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
(def _p56
  ;;TODO your solution here
  )

(solve problem56 
  (= (_p56 [1 2 1 3 1 2 4]) [1 2 3 4])
  (= (_p56 [:a :a :b :b :c :c]) [:a :b :c])
  (= (_p56 '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
  (= (_p56 (range 50)) (range 50)))

;; Problem 58:  Function Composition
;; Write a function which allows you to create function compositions.  The parameter list should take a variable number of functions, and create a function applies them from right-to-left.
(def _p58
  ;;TODO your solution here
  )

(solve problem58 
  (= [3 2 1] ((_p58 rest reverse) [1 2 3 4]))
  (= 5 ((_p58 (partial + 3) second) [1 2 3 4]))
  (= true ((_p58 zero? #(mod % 8) +) 3 5 7 9))
  (= "HELLO" ((_p58 #(.toUpperCase %) #(apply str %) take) 5 "hello world")))

;; Problem 59:  Juxtaposition
;; Take a set of functions and return a new function that takes a variable number of arguments and returns a sequence containing the result of applying each function left-to-right to the argument list.
(def _p59
  ;;TODO your solution here
  )

(solve problem59 
  (= [21 6 1] ((_p59 + max min) 2 3 5 1 6 4))
  (= ["HELLO" 5] ((_p59 #(.toUpperCase %) count) "hello"))
  (= [2 6 4] ((_p59 :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})))

;; Problem 60:  Sequence Reductions
;; Write a function which behaves like reduce, but returns each intermediate value of the reduction.  Your function must accept either two or three arguments, and the return sequence must be lazy.
(def _p60
  ;;TODO your solution here
  )

(solve problem60 
  (= (take 5 (_p60 + (range))) [0 1 3 6 10])
  (= (_p60 conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
  (= (last (_p60 * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120))

;; Problem 65:  Black Box Testing
;; Clojure has many sequence types, which act in subtly different ways. The core functions typically convert them into a uniform "sequence" type and work with them that way, but it can be important to understand the behavioral and performance differences so that you know which kind is appropriate for your application.<br /><br />Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.<br />You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.
(def _p65
  ;;TODO your solution here
  )

(solve problem65 
  (= :map (_p65 {:a 1, :b 2}))
  (= :list (_p65 (range (rand-int 20))))
  (= :vector (_p65 [1 2 3 4 5 6]))
  (= :set (_p65 #{10 (rand-int 5)}))
  (= [:map :set :vector :list] (map _p65 [{} #{} [] ()])))

;; Problem 67:  Prime Numbers
;; Write a function which returns the first x
;;number of prime numbers.
(def _p67
  ;;TODO your solution here
  )

(solve problem67 
  (= (_p67 2) [2 3])
  (= (_p67 5) [2 3 5 7 11])
  (= (last (_p67 100)) 541))

;; Problem 69:  Merge with a Function
;; Write a function which takes a function f and a variable number of maps.  Your function should return a map that consists of the rest of the maps conj-ed onto the first.  If a key occurs in more than one map, the mapping(s) from the latter (left-to-right) should be combined with the mapping in the result by calling (f val-in-result val-in-latter)
(def _p69
  ;;TODO your solution here
  )

(solve problem69 
  (= (_p69 * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
   {:a 4, :b 6, :c 20})
  (= (_p69 - {1 10, 2 20} {1 3, 2 10, 3 15})
   {1 7, 2 10, 3 15})
  (= (_p69 concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]}))

;; Problem 70:  Word Sorting
;; Write a function that splits a sentence up into a sorted list of words.  Capitalization should not affect sort order and punctuation should be ignored.
(def _p70
  ;;TODO your solution here
  )

(solve problem70 
  (= (_p70  "Have a nice day.")
   ["a" "day" "Have" "nice"])
  (= (_p70  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])
  (= (_p70  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"]))

;; Problem 74:  Filter Perfect Squares
;; Given a string of comma separated integers, write a function which returns a new comma separated string that only contains the numbers which are perfect squares.
(def _p74
  ;;TODO your solution here
  )

(solve problem74 
  (= (_p74 "4,5,6,7,8,9") "4,9")
  (= (_p74 "15,16,25,36,37") "16,25,36"))

;; Problem 75:  Euler's Totient Function
;; Two numbers are coprime if their greatest common divisor equals 1.  Euler's totient function f(x) is defined as the number of positive integers less than x which are coprime to x.  The special case f(1) equals 1.  Write a function which calculates Euler's totient function.
(def _p75
  ;;TODO your solution here
  )

(solve problem75 
  (= (_p75 1) 1)
  (= (_p75 10) (count '(1 3 7 9)) 4)
  (= (_p75 40) 16)
  (= (_p75 99) 60))

;; Problem 76:  Intro to Trampoline
;; The trampoline function takes a function f and a variable number of parameters.  Trampoline calls f with any parameters that were supplied.  If f returns a function, trampoline calls that function with no arguments.  This is repeated, until the return value is not a function, and then trampoline returns that non-function value.  This is useful for implementing mutually recursive algorithms in a way that won't consume the stack.
(def _p76
  ;;TODO your solution here
  )

(solve problem76 
  (= _p76
   (letfn
     [(foo [x y] #(bar (conj x y) y))
      (bar [x y] (if (> (last x) 10)
                   x
                   #(foo x (+ 2 y))))]
     (trampoline foo [] 1))))

;; Problem 77:  Anagram Finder
;; Write a function which finds all the anagrams in a vector of words.  A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y.  Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other.  Each sub-set should have at least two words.  Words without any anagrams should not be included in the result.
(def _p77
  ;;TODO your solution here
  )

(solve problem77 
  (= (_p77 ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})
  (= (_p77 ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))

;; Problem 78:  Reimplement Trampoline
;; Reimplement the function described in <a href="76"> "Intro to Trampoline"</a>.
(def _p78
  ;;TODO your solution here
  )

(solve problem78 
  (= (letfn [(triple [x] #(sub-two (* 3 x)))
          (sub-two [x] #(stop?(- x 2)))
          (stop? [x] (if (> x 50) x #(triple x)))]
    (_p78 triple 2))
  82)
  (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
          (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
    (map (partial _p78 my-even?) (range 6)))
  [true false true false true false]))

;; Problem 80:  Perfect Numbers
;; A number is "perfect" if the sum of its divisors equal the number itself.  6 is a perfect number because 1+2+3=6.  Write a function which returns true for perfect numbers and false otherwise.
(def _p80
  ;;TODO your solution here
  )

(solve problem80 
  (= (_p80 6) true)
  (= (_p80 7) false)
  (= (_p80 496) true)
  (= (_p80 500) false)
  (= (_p80 8128) true))

;; Problem 85:  Power Set
;; Write a function which generates the <a href="http://en.wikipedia.org/wiki/Power_set">power set</a> of a given set.  The power set of a set x is the set of all subsets of x, including the empty set and x itself.
(def _p85
  ;;TODO your solution here
  )

(solve problem85 
  (= (_p85 #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
  (= (_p85 #{}) #{#{}})
  (= (_p85 #{1 2 3})
   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
  (= (count (_p85 (into #{} (range 10)))) 1024))

;; Problem 86:  Happy numbers
;; Happy numbers are positive integers that follow a particular formula: take each individual digit, square it, and then sum the squares to get a new number. Repeat with the new number and eventually, you might get to a number whose squared sum is 1. This is a happy number. An unhappy number (or sad number) is one that loops endlessly. Write a function that determines if a number is happy or not.
(def _p86
  ;;TODO your solution here
  )

(solve problem86 
  (= (_p86 7) true)
  (= (_p86 986543210) true)
  (= (_p86 2) false)
  (= (_p86 3) false))

;; Problem 93:  Partially Flatten a Sequence
;; Write a function which flattens any nested combination of sequential things (lists, vectors, etc.), but maintains the lowest level sequential items.  The result should be a sequence of sequences with only one level of nesting.
(def _p93
  ;;TODO your solution here
  )

(solve problem93 
  (= (_p93 [["Do"] ["Nothing"]])
   [["Do"] ["Nothing"]])
  (= (_p93 [[[[:a :b]]] [[:c :d]] [:e :f]])
   [[:a :b] [:c :d] [:e :f]])
  (= (_p93 '((1 2)((3 4)((((5 6)))))))
   '((1 2)(3 4)(5 6))))

;; Problem 98:  Equivalence Classes
;; A function f defined on a domain D induces an <a href="http://en.wikipedia.org/wiki/Equivalence_relation">equivalence relation</a> on D, as follows: a is equivalent to b with respect to f if and only if (f a) is equal to (f b).  Write a function with arguments f and D that computes the <a href="http://en.wikipedia.org/wiki/Equivalence_class">equivalence classes</a> of D with respect to f.
(def _p98
  ;;TODO your solution here
  )

(solve problem98 
  (= (_p98 #(* % %) #{-2 -1 0 1 2})
   #{#{0} #{1 -1} #{2 -2}})
  (= (_p98 #(rem % 3) #{0 1 2 3 4 5 })
   #{#{0 3} #{1 4} #{2 5}})
  (= (_p98 identity #{0 1 2 3 4})
   #{#{0} #{1} #{2} #{3} #{4}})
  (= (_p98 (constantly true) #{0 1 2 3 4})
   #{#{0 1 2 3 4}})
)

;; Problem 102:  intoCamelCase
;; When working with java, you often need to create an object with <code>fieldsLikeThis</code>, but you'd rather work with a hashmap that has <code>:keys-like-this</code> until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.
(def _p102
  ;;TODO your solution here
  )

(solve problem102 
  (= (_p102 "something") "something")
  (= (_p102 "multi-word-key") "multiWordKey")
  (= (_p102 "leaveMeAlone") "leaveMeAlone"))

;; Problem 103:  Generating k-combinations
;; Given a sequence S consisting of n elements generate all <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Combination">k-combinations</a> of S, i. e. generate all possible sets consisting of k distinct elements taken from S.
;
;The number of k-combinations for a sequence is equal to the <a href="https://secure.wikimedia.org/wikipedia/en/wiki/Binomial_coefficient">binomial coefficient</a>.
(def _p103
  ;;TODO your solution here
  )

(solve problem103 
  (= (_p103 1 #{4 5 6}) #{#{4} #{5} #{6}})
  (= (_p103 10 #{4 5 6}) #{})
  (= (_p103 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}})
  (= (_p103 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                         #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}})
  (= (_p103 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}})
  (= (_p103 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                    #{:a "abc"} #{:a "efg"} #{"abc" "efg"}}))

;; Problem 104:  Write Roman Numerals
;; This is the inverse of <a href='92'>Problem 92</a>, but much easier. Given an integer smaller than 4000, return the corresponding roman numeral in uppercase, adhering to the <a href='http://www.numericana.com/answer/roman.htm#valid'>subtractive principle</a>.
(def _p104
  ;;TODO your solution here
  )

(solve problem104 
  (= "I" (_p104 1))
  (= "XXX" (_p104 30))
  (= "IV" (_p104 4))
  (= "CXL" (_p104 140))
  (= "DCCCXXVII" (_p104 827))
  (= "MMMCMXCIX" (_p104 3999))
  (= "XLVIII" (_p104 48)))

;; Problem 105:  Identify keys and values
;; Given an input sequence of keywords and numbers, create a map such that each key in the map is a keyword, and the value is a sequence of all the numbers (if any) between it and the next keyword in the sequence.
(def _p105
  ;;TODO your solution here
  )

(solve problem105 
  (= {} (_p105 []))
  (= {:a [1]} (_p105 [:a 1]))
  (= {:a [1], :b [2]} (_p105 [:a 1, :b 2]))
  (= {:a [1 2 3], :b [], :c [4]} (_p105 [:a 1 2 3 :b :c 4])))

;; Problem 108:  Lazy Searching
;; <p>Given any number of sequences, each sorted from smallest to largest, find the smallest single number which appears in all of the sequences. The sequences may be infinite, so be careful to search lazily.</p>
(def _p108
  ;;TODO your solution here
  )

(solve problem108 
  (= 3 (_p108 [3 4 5]))
  (= 4 (_p108 [1 2 3 4 5 6 7] [0.5 3/2 4 19]))
  (= 7 (_p108 (range) (range 0 100 7/6) [2 3 5 7 11 13]))
  (= 64 (_p108 (map #(* % % %) (range)) ;; perfect cubes
          (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
          (iterate inc 20)))) ;; at least as large as 20)

;; Problem 110:  Sequence of pronunciations
;; <p>Write a function that returns a lazy sequence of "pronunciations" of a sequence of numbers. A pronunciation of each element in the sequence consists of the number of repeating identical numbers and the number itself. For example, <code>[1 1]</code> is pronounced as <code>[2 1]</code> ("two ones"), which in turn is pronounced as <code>[1 2 1 1]</code> ("one two, one one").</p><p>Your function should accept an initial sequence of numbers, and return an infinite lazy sequence of pronunciations, each element being a pronunciation of the previous element.</p>
(def _p110
  ;;TODO your solution here
  )

(solve problem110 
  (= [[1 1] [2 1] [1 2 1 1]] (take 3 (_p110 [1])))
  (= [3 1 2 4] (first (_p110 [1 1 1 4 4])))
  (= [1 1 1 3 2 1 3 2 1 1] (nth (_p110 [1]) 6))
  (= 338 (count (nth (_p110 [3 2]) 15)))
)

;; Problem 112:  Sequs Horribilis
;; Create a function which takes an integer and a nested collection of integers as arguments.  Analyze the elements of the input collection and return a sequence which maintains the nested structure, and which includes all elements starting from the head whose sum is less than or equal to the input integer.
(def _p112
  ;;TODO your solution here
  )

(solve problem112 
  (=  (_p112 10 [1 2 [3 [4 5] 6] 7])
   '(1 2 (3 (4))))
  (=  (_p112 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
   '(1 2 (3 (4 (5 (6 (7)))))))
  (=  (_p112 9 (range))
   '(0 1 2 3))
  (=  (_p112 1 [[[[[1]]]]])
   '(((((1))))))
  (=  (_p112 0 [1 2 [3 [4 5] 6] 7])
   '())
  (=  (_p112 0 [0 0 [0 [0]]])
   '(0 0 (0 (0))))
  (=  (_p112 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
   '(-10 (1 (2 3 (4))))))

;; Problem 114:  Global take-while
;; <p><a
;href="http://clojuredocs.org/clojure_core/clojure.core/take-while">take-while</a>
;is great for filtering sequences, but it limited: you can only examine
;a single item of the sequence at a time. What if you need to keep
;track of some state as you go over the sequence?</p>
;
;<p>Write a function which accepts an integer <code>n</code>, a predicate <code>p</code>, and a sequence. It should return a lazy sequence of items in the list up to, but not including, the <code>n</code>th item that satisfies the predicate.</p>
(def _p114
  ;;TODO your solution here
  )

(solve problem114 
  (= [2 3 5 7 11 13]
   (_p114 4 #(= 2 (mod % 3))
         [2 3 5 7 11 13 17 19 23]))
  (= ["this" "is" "a" "sentence"]
   (_p114 3 #(some #{\i} %)
         ["this" "is" "a" "sentence" "i" "wrote"]))
  (= ["this" "is"]
   (_p114 1 #{"a"}
         ["this" "is" "a" "sentence" "i" "wrote"])))

;; Problem 115:  The Balance of N
;; A balanced number is one whose component digits have the same sum on the left and right halves of the number.  Write a function which accepts an integer n, and returns true iff n is balanced.
(def _p115
  ;;TODO your solution here
  )

(solve problem115 
  (= true (_p115 11))
  (= true (_p115 121))
  (= false (_p115 123))
  (= true (_p115 0))
  (= false (_p115 88099))
  (= true (_p115 89098))
  (= true (_p115 89089))
  (= (take 20 (filter _p115 (range)))
   [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])  )

;; Problem 116:  Prime Sandwich
;; A <a href="http://en.wikipedia.org/wiki/Balanced_prime">balanced prime</a> is a prime number which is also the mean of the primes directly before and after it in the sequence of valid primes.  Create a function which takes an integer n, and returns true iff it is a balanced prime.
(def _p116
  ;;TODO your solution here
  )

(solve problem116 
  (= false (_p116 4))
  (= true (_p116 563))
  (= 1103 (nth (filter _p116 (range)) 15)))

;; Problem 131:  Sum Some Set Subsets
;; Given a variable number of sets of integers, create a function which returns true iff all of the sets have a non-empty subset with an equivalent summation.
(def _p131
  ;;TODO your solution here
  )

(solve problem131 
  (= true  (_p131 #{-1 1 99} 
             #{-2 2 888}
             #{-3 3 7777})) ; ex. all sets have a subset which sums to zero
  (= false (_p131 #{1}
             #{2}
             #{3}
             #{4}))
  (= true  (_p131 #{1}))
  (= false (_p131 #{1 -3 51 9} 
             #{0} 
             #{9 2 81 33}))
  (= true  (_p131 #{1 3 5}
             #{9 11 4}
             #{-3 12 3}
             #{-3 4 -2 10}))
  (= false (_p131 #{-1 -2 -3 -4 -5 -6}
             #{1 2 3 4 5 6 7 8 9}))
  (= true  (_p131 #{1 3 5 7}
             #{2 4 6 8}))
  (= true  (_p131 #{-1 3 -5 7 -9 11 -13 15}
             #{1 -3 5 -7 9 -11 13 -15}
             #{1 -1 2 -2 4 -4 8 -8}))
  (= true  (_p131 #{-10 9 -8 7 -6 5 -4 3 -2 1}
             #{10 -9 8 -7 6 -5 4 -3 2 -1})))

;; Problem 132:  Insert between two items
;; Write a function that takes a two-argument predicate, a value, and a collection; and returns a new collection where the <code>value</code> is inserted between every two items that satisfy the predicate.
(def _p132
  ;;TODO your solution here
  )

(solve problem132 
  (= '(1 :less 6 :less 7 4 3) (_p132 < :less [1 6 7 4 3]))
  (= '(2) (_p132 > :more [2]))
  (= [0 1 :x 2 :x 3 :x 4]  (_p132 #(and (pos? %) (< % %2)) :x (range 5)))
  (empty? (_p132 > :more ()))
  (= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
   (take 12 (->> [0 1]
                 (iterate (fn [[a b]] [b (+ a b)]))
                 (map first) ; fibonacci numbers
                 (_p132 (fn [a b] ; both even or both odd
                       (= (mod a 2) (mod b 2)))
                     :same)))))

;; Problem 137:  Digits and bases
;; Write a function which returns a sequence of digits of a non-negative number (first argument) in numerical system with an arbitrary base (second argument). Digits should be represented with their integer values, e.g. 15 would be [1 5] in base 10, [1 1 1 1] in base 2 and [15] in base 16. 
(def _p137
  ;;TODO your solution here
  )

(solve problem137 
  (= [1 2 3 4 5 0 1] (_p137 1234501 10))
  (= [0] (_p137 0 11))
  (= [1 0 0 1] (_p137 9 2))
  (= [1 0] (let [n (rand-int 100000)](_p137 n n)))
  (= [16 18 5 24 15 1] (_p137 Integer/MAX_VALUE 42)))

;; Problem 141:  Tricky card games
;; <p>
;  In <a href="http://en.wikipedia.org/wiki/Trick-taking_game">trick-taking
;  card games</a> such as bridge, spades, or hearts, cards are played
;  in groups known as "tricks" - each player plays a single card, in
;  order; the first player is said to "lead" to the trick. After all
;  players have played, one card is said to have "won" the trick. How
;  the winner is determined will vary by game, but generally the winner
;  is the highest card played <i>in the suit that was
;  led</i>. Sometimes (again varying by game), a particular suit will
;  be designated "trump", meaning that its cards are more powerful than
;  any others: if there is a trump suit, and any trumps are played,
;  then the highest trump wins regardless of what was led.
;</p>
;<p>
;  Your goal is to devise a function that can determine which of a
;  number of cards has won a trick. You should accept a trump suit, and
;  return a function <code>winner</code>. Winner will be called on a
;  sequence of cards, and should return the one which wins the
;  trick. Cards will be represented in the format returned
;  by <a href="/problem/128/">Problem 128, Recognize Playing Cards</a>:
;  a hash-map of <code>:suit</code> and a
;  numeric <code>:rank</code>. Cards with a larger rank are stronger.
;</p>
(def _p141
  ;;TODO your solution here
  )

(solve problem141 
  (let [notrump (_p141 nil)]
  (and (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 4}
                                           {:suit :club :rank 9}]))
       (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                           {:suit :club :rank 10}]))))
  (= {:suit :club :rank 10} ((_p141 :club) [{:suit :spade :rank 2}
                                       {:suit :club :rank 10}]))
  (= {:suit :heart :rank 8}
   ((_p141 :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                 {:suit :diamond :rank 10} {:suit :heart :rank 4}])))

;; Problem 144:  Oscilrate
;; Write an oscillating iterate: a function that takes an initial value and a variable number of functions. It should return a lazy sequence of the functions applied to the value in order, restarting from the first function after it hits the end.
(def _p144
  ;;TODO your solution here
  (fn oscilrate [n f & fs]
    (lazy-seq (cons n (apply oscilrate (f n) (concat fs [f]) )))))

(solve problem144 
  (= (take 3 (_p144 3.14 int double)) [3.14 3 3.0])
  (= (take 5 (_p144 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])
  (= (take 12 (_p144 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])
)

;; Problem 148:  The Big Divide
;; <p>Write a function which calculates the sum of all natural numbers under <i>n</i> (first argument) which are evenly divisible by at least one of <i>a</i> and <i>b</i> (second and third argument). Numbers <i>a</i> and <i>b</i> are guaranteed to be <a href="http://en.wikipedia.org/wiki/Coprime">coprimes</a>.</p>
;
;<p>Note: Some test cases have a very large <i>n</i>, so the most obvious solution will exceed the time limit.</p>
(def _p148
  ;;TODO your solution here
  )

(solve problem148 
  (= 0 (_p148 3 17 11))
  (= 23 (_p148 10 3 5))
  (= 233168 (_p148 1000 3 5))
  (= "2333333316666668" (str (_p148 100000000 3 5)))
  (= "110389610389889610389610"
  (str (_p148 (* 10000 10000 10000) 7 11)))
  (= "1277732511922987429116"
  (str (_p148 (* 10000 10000 10000) 757 809)))
  (= "4530161696788274281"
  (str (_p148 (* 10000 10000 1000) 1597 3571))))

;; Problem 150:  Palindromic Numbers
;; <p>A palindromic number is a number that is the same when written forwards or backwards (e.g., 3, 99, 14341).</p>
;
;<p>Write a function which takes an integer <code>n</code>, as its only argument, and returns an increasing lazy sequence of all palindromic numbers that are not less than <code>n</code>.</p>
;
;<p>The most simple solution will exceed the time limit!</p>
(def _p150
  ;;TODO your solution here
  )

(solve problem150 
  (= (take 26 (_p150 0))
   [0 1 2 3 4 5 6 7 8 9 
    11 22 33 44 55 66 77 88 99 
    101 111 121 131 141 151 161])
  (= (take 16 (_p150 162))
   [171 181 191 202 
    212 222 232 242 
    252 262 272 282 
    292 303 313 323])
  (= (take 6 (_p150 1234550000))
   [1234554321 1234664321 1234774321 
    1234884321 1234994321 1235005321])
  (= (first (_p150 (* 111111111 111111111)))
   (* 111111111 111111111))
  (= (set (take 199 (_p150 0)))
   (set (map #(first (_p150 %)) (range 0 10000))))
  (= true 
   (apply < (take 6666 (_p150 9999999))))
  (= (nth (_p150 0) 10101)
   9102019))

;; Problem 158:  Decurry
;; Write a function that accepts a curried function of unknown arity <i>n</i>.  Return an equivalent function of <i>n</i> arguments.
;;<br/>
;;You may wish to read <a href="http://en.wikipedia.org/wiki/Currying">this</a>.
(def _p158
  ;;TODO your solution here
  )

(solve problem158 
  (= 10 ((_p158 (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (+ a b c d))))))
       1 2 3 4))
  (= 24 ((_p158 (fn [a]
             (fn [b]
               (fn [c]
                 (fn [d]
                   (* a b c d))))))
       1 2 3 4))
  (= 25 ((_p158 (fn [a]
             (fn [b]
               (* a b))))
       5 5))
)

