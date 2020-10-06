import Data.List

{- EXERCÍCIO 1 -}
-- a) ... g)
a_res = [[1,2,3]] ++ [] ++ [[4],[5]] == [[1,2,3],[4],[5]]
b_res = length ([1]:[2]:[]:[3]:[4]:[]) == 5
c_res = take 7 [8,6..0] == [8,6,4,2,0]
d_res = fst ([(1,2),(3,4),(5,6),(9,7),(8,13)] !! 3) == 9
e_res = [ (y,x) | x <- [1,2], y <- [x..4]] == [(1,1),(2,1),(3,1),(4,1),(2,2),(3,2),(4,2)]
f_res = [2 ^ x| x <- [1..5], y <- [1..3], (x + y) `mod` 3 == 0] == [2,4,8,16,32]
g_res = [1,3,7,15,31,63,127,255,511,1023] == [ 2^x - 1 | x <- [1..10] ]

-- h)
f [] = 1
f [x] = x
f (x:xs) = x + f xs

h_res = f [1..5] == 15

-- i)
i_res :: ([Bool],[Char])
i_res = ([False, True], ['1', '2'])

-- j)
p :: a -> b -> (a,b)
p x y = (x,y)

-- k)
h :: Eq a => [a] -> [a] -> [a]
h [] l = l
h [x] l = x:l
h (x:y:ys) l = if x == y then h ys (x:l) else h (y:ys) (x:l)

-- l)
feql :: Eq a => [a] -> Bool
feql xs = head xs == head (reverse (tail xs))

{- EXERCÍCIO 2 -}
-- a)
distancia :: Floating a => (a,a) -> (a,a) -> a
distancia (x1,y1) (x2,y2) = sqrt ((x2-x1)^2 + (y2-y1)^2)

-- b)
declive :: Floating a => (a,a) -> (a,a) -> a
declive (x1,y1) (x2,y2) = (y1 - y2) / (x1 - x2)

colineares :: Floating a => (a,a) -> (a,a) -> (a,a) -> Bool
colineares a b c = declive a b == declive b c

{- EXERCÍCIO 3 -}
-- a)
niguaisR :: Int -> a -> [a]
niguaisR 0 _ = []
niguaisR n x = x : (niguaisR (n-1) x)

-- b)
niguaisLC :: Int -> a -> [a]
niguaisLC n x = [ x | a <- [1..n] ]

{- EXERCÍCIO 4 -}
merge :: Ord a => [a] -> [a] -> [a]
merge [] [] = []
merge xs [] = xs
merge [] ys = ys
merge (x : xs) (y : ys)
      | x <= y = x : merge xs (y : ys)
      | otherwise = y : merge (x : xs) ys

{- EXERCÍCIO 5 -}
length_zip :: [a] -> [(Int,a)]
length_zip xs = zip [length xs .. 1, length xs-1..1] xs

{- EXERCÍCIO 6 -}
dot_append :: [[a]] -> [[a]] -> [[a]]
dot_append as bs = [a ++ b | a <- as, b <- bs]

combinacoes :: Int -> [[a]] -> [[a]]
combinacoes n as = foldr1 dot_append (niguaisR n as)

l2ls :: [a] -> [[a]]
l2ls [] = []
l2ls (x:xs) = [x] : l2ls xs

removeFirst :: (a -> Bool) -> [a] -> [a]
removeFirst _ [] = []
removeFirst p (x:xs) = if p x then xs else x : removeFirst p xs

allElems :: Eq a => [a] -> [a] -> Bool
allElems [] _ = True
allElems (x:xs) ys = if elem x ys then allElems xs (removeFirst (==x) ys) else False 

nubs :: Eq a => [[a]] -> [[a]]
nubs [] = []
nubs (x:xs) = x : filter (\l -> not (allElems x l)) xs

decompor :: Int -> [Int] -> [[Int]]
decompor n xs = nubs [ x | x <- combinacoes (length xs) xss, sum x == n ]
         where xss = l2ls xs
