-- Exercicio 38
or1 :: [Bool] -> Bool
or1 [] = False
or1(x:xs) = x || or1 xs

concat1 :: [[a]] -> [a]
concat1 [] = []
concat1(x:xs) = x ++ concat xs

replicate1 :: Int -> a -> [a]
replicate1 0 _ = []
replicate1 n x = x:replicate1(n-1)x

(!!!) :: [a] -> Int -> a
(!!!) [] _ = error "empty list"
(!!!) (x:xs) i  | i == 0 = x
                | otherwise = (!!!) xs(i-1)

elem1 :: Eq a => a -> [a] -> Bool
elem1 _ [] = False
elem1 e (x:xs)
    | e == x = True
    |otherwise = elem e xs

-- Exercicio 40
forte :: String -> Bool
forte s = isBig && hasM && hasm && hasA
      where isBig = length s >= 8
            hasM  = or [c>='A' && c<='Z' |c<-s]
            hasm  = or [c>='a' && c<='z' |c<-s]
            hasA  = or [c>='0' && c<='9' |c<-s]

-- Exercicio 41
filter1 x ys = [y | y<-ys, x/=y]

nub :: Eq a => [a] -> [a]
nub [] = []
nub (x:xs) = x : nub(filter1 x xs)

-- Exercicio 42
intersperse :: a ->[a] ->[a]
intersperse _ [] = []

intersperse _ [y] = [y]
intersperse x (y:ys) = y:x:intersperse x ys

-- Exercicio 43
insert :: Ord a => a -> [a] -> [a]
insert x [] = [x]
insert x (y:ys) | x <= y = x:y:ys
                | otherwise = y:insert x ys

isort :: Ord a => [a] -> [a]
isort [] = []
isort (x:xs) = insert x (isort xs)
