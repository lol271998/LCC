--MAP
{-
soma2 :: [Int] -> [Int]
som2 [] = []
soma2 (h:t) = (h+2) : soma2 t
-}

--FILTER
{-
remove2 :: [Int] -> [Int]
remove2 [] = []
remove2 (h:t) | (h/) 
-}
--FOLD
somatorio :: [Int] -> Int
somatorio [] = 0
somatorio (h:t) = h + (somatorio t)

multList :: [Int] -> Int
multList [] = 1
multList (h:t) = h * (multList t)

--[4,2,3,5]
-- somatorio [4,2,3,5]
--4 + (somatorio [2,3,5])
--4 + (2 + (3 + (somatorio [5])))
--4 + (2 + (3 + (5 + somatorio [])))))
--4 +

--47
-- [f x | x ← xs, p x] <=> map f(filter p xs))
--listac f p = [f x | x <- xs,p x]
--listac2 f p xs = map f (filter p xs)

--foldr
--f 0 [1,2,3]
--f 1(f 2(f 3 0))

--foldl
--f 0 [1,2,3]
--f(f(f 0 1) 2) 3

--48
--a)
plusplus :: [a] -> [a] -> [a]
plusplus [] l = l -- (?1)
plusplus (h:t) l = h:(plusplus t l) --(?2)

pluplusf :: [a] -> [a] -> [a]
pluplusf l1 l2 = foldr (:) l2 l1  

--b)
concatf :: [[a]] -> [a]
concatf l = foldr (++) [] l

--c)

aux a b = b ++ [a]

reversefoldr l = (\v l -> l ++ [v]) [] l
reversefoldr2 l = foldr aux [] l
-- f ? [1,2,3,4,5]
-- f 1 (f 2(f 3(f 4(f 5 ?))))
-- f 1 (f 2(f 3(f 4 [5])))
-- f 1 (f 2(f 3 [5,4]))
-- f 1 (f 2 [5,4,3])
-- f 1 ([5,4,3,2])
-- [5,4,3,2,1]

--d)
reversefoldl l = foldl (\l v -> v:l) [] l
reversefoldl2 l = foldl(\l v -> [v]++l) [] l

--e)
elem2 :: Eq a => a -> [a] -> Bool
elem2 v l = any(\x -> x == v) l

--elem2 4 [1..5]
-- any (\x->x == 4) [1,2,3,4,5]
-- [(1==4),(2==4),(4==4),(5==4)]

--49
dec2int :: [Int] -> Int
dec2int l = foldl (\x y-> x*10+y) 0 l

-- dec2int [1,2,3,4,5]
-- f [1,2,3,4,5]
-- f (f (f (f( f( f(?1) 1 )2 )3 ) 4) 5    --x = 0, y = 1; x*10 + y = 1
-- f (f (f (f (?2) 2) 3) 4) 5				...		
-- f (f (f (?3) 3) 4) 5
-- f ((?4) 4) 5
-- f (?5) 5
-- 1234

--(\x y -> x*10 + y) = (?1)

--zipWithrec f _ [] = []
--zipWithrec f (x:xs) (y:ys) = (f x y) : (zipWithrec f xs ys)
{-
insertt :: Ord a => a -> [a] -> [a]
insertt v [] = [v]
insertt v (h:t) | (v<h) = h:t
				| otherwise = h:(insertt v t)
-}
--isort l = foldr(\v l -> insertt v l) [] l 

--52

shift :: [a] -> [a]
shift [] = []
shift (x:xs) = xs++[x]

rotate :: [a] ->[[a]]
rotate [] = []
rotate l = foldr (\v l -> l++[shift (last l)]) [l] (tail l)

{-53 a)
maximumfl1 :: (Ord a) => [a] -> a
maximumfl1 l = foldl max l

maximumfr1 :: (Ord a) => [a] -> a
maximumfr1 l = foldl max l

--53 b-}

foldr2 f l = foldr f (last l) l

foldl2 f l = foldl f (head l) l