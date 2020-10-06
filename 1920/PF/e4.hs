-- Fazer do 31 ao 36
--31
exp2n :: Int->Int
exp2n 0 = 1
exp2n 1 = 2
exp2n n = 2 * exp2n (n-1)
--32,33
--a)
and' :: [Bool] -> Bool
and' [] = True
and' (x:xs) = if x == True then (and' xs) else False

--b)
or' :: [Bool] -> Bool
or' [] = False
or' (x:xs) = if x == False then (or' xs) else True

--c)
{-
concat'::[[a]] -> [a]
concat' [[]] = []
concat' [x:[]] = [x]
-}

--d)
replicate' :: Int -> a -> [a]
replicate' 0 v = []
replicate' n v = v : (replicate' (n-1) v)

replicate'' n v = [v |x<-[1..n]]

--e)
sel :: [a] -> Int -> a
sel (x:xs) 0 = last (x:xs)
sel (x:xs) n = sel (x:xs) (n-1)
{-
sel' :: [a] -> Int -> a
sel' l n = last[k |k<-] 
-}

--f)
elem' :: Eq a => a -> [a] -> Bool
elem' v [] = False
elem' v (x:xs) = if v == x then True else elem' v xs 

--34
--a)
leastSquare :: Int -> Int
leastSquare n = aux 1 n

aux :: Int -> Int -> Int
aux x n | (x*x>n) = (x-1)
        | otherwise = aux (x+1) n

--b)
isqrtn n = last[x | x<-[1..n],x*x<=n]

-- 35
rangeProduct a b | (a==b) = a
                 | otherwise = a*(rangeProduct (a+1) b)
