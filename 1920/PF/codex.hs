--ex.30

maius :: String -> Bool
maius [] = False
maius (h:hs) = if(h>='A' && h<='Z') then True else maius hs 


minus :: String -> Bool
minus [] = False
minus (h:hs) = if(h>='a' && h<='z') then True else minus hs

hasNumber :: String -> Bool
hasNumber [] = False
hasNumber (h:hs) = if(h>='0' && h<='9') then True else hasNumber hs

forte :: String -> Bool
forte str = if (length str>=6 && maius str && minus str && hasNumber str) then True else False

--ex.32 (b)

myand :: [Bool] -> Bool
myand [] = True
myand (h:hs) = if h then myand hs else False

--ex.32 (b)

myor :: [Bool] -> Bool
myor [] = False
myor (h:hs) = if h then True else myor hs

--Ex 38
{-
intersperse 0 [1,2,3] = [1,0,2,0,3]
intersperse 0 [1] = [1]
intersperse 0 []   = []
-}

intersperse :: a -> [a] -> [a]
intersperse a [] = []
intersperse a [b] = [b]
intersperse a (h:hs) = h:(a:intersperse a hs)

--Ex 40
f :: Integer -> Integer
f a = 2*a

anyZero :: (Integer -> Integer) -> Integer -> Bool
anyZero f 0 = if f 0 == 0 then True else False 
anyZero f a = if f a == 0 then True else anyZero f (a-1)


-- 42 (a)
{-
insert 1 []      = [1]
insert 0 [1,2,3] = [0,1,2,3]
insert 2 [1,3,4] = [1,2,3,4]
insert 3 [1,2,3] = [1,2,3,3]
-}

insert :: Ord a => a -> [a] -> [a]
insert a [] = [a]
insert a (h:hs) =if a<=h then (a:h:hs) else h:(insert a hs)


--42 b)
isort :: Ord a => [a] -> [a]
isort [] = []
isort [a] = [a]
isort (h:hs) = insert h (isort hs) 

--43 a)
--import Prelude hiding (minimum)
-- esconder a definição no prelúdio

minimu :: Ord a => [a] -> a
minimu [a] = a
minimu [a,b] = if a <= b then a else b
minimu (h:hs) = if h<=minimu(hs) then h else minimu(hs)

--43 b)

delete :: Eq a => a -> [a] -> [a]
delete x [] = []
delete x [a] = if x == a then [] else [a]
delete x (h:hs) = if x == h then hs else h:(delete x hs)

--44 a)

merge :: Ord a => [a] -> [a] -> [a]
merge [] [] = []
merge a [] = a
merge [] a = a
merge [a] [b] = if a<=b then [a,b] else [b,a]
merge (h:hs) (x:xs) = if h<=x then h:(merge hs (x:xs)) else x:(merge (h:hs) xs)    

--44 b)
metades l = (l1,l2)
        where l1 = take ((length l) `div` 2) l
              l2 = drop ((length l) `div` 2) l



msort :: Ord a => [a] -> [a]
msort [] = []
msort [a] = [a]
msort [a,b] = if a<=b then [a,b] else [b,a]
msort l = merge (msort(fst (metades l))) (msort(snd(metades l)))


permutations :: [a] -> [[a]]
permutations []     = [[]]
permutations (x:xs) = [y | p <- permutations xs, y <- interleave p]
  where
    interleave []     = [[x]]
    interleave (y:ys) = (x:y:ys) : map (y:) (interleave ys)

permutations1 :: [a] -> [[a]]
permutations1 []  = [[]]
permutations1 xxs = [(y:ys) | (y,xs) <- picks xxs, ys <- permutations1 xs]
  where
    picks (x:xs) = (x,xs) : [(y,x:ys) | (y,ys) <- picks xs]

--48 a)
-- esconder a definição do prelúdio 
--import Prelude hiding ((++))

-- completar esta definição
plusplus :: [a] -> [a] -> [a]
plusplus xs ys = foldr f z lista
              where f = (:)
                    z = ys
                    lista = xs

--48 c)

-- esconder a definição do prelúdio 
--import Prelude hiding (reverse)
aux a b = b ++ [a]
-- completar esta definição
reverse1 :: [a] -> [a]
reverse1 xs = foldr f z xs
            where f = aux
                  z = []

-- 49

dec2int :: [Int] -> Int
dec2int xs = foldl f z xs
           where f = (\x y-> x*10+y)
                 z = 0

--50

-- completar a nova definição
zipWith1 :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWith1 _ [] [] = []
zipWith1 _ a [] = []
zipWith1 _ [] a = []
zipWith1 f (x:xs) (y:ys) = (f x y:zipWith1 f xs ys)

--52
rotate :: [a] -> [[a]]
rotate [] = []
rotate l = foldr f [l] (tail l)
         where f = (\v l -> l ++ [shift(last l)])
-- completar esta definição

shift :: [a] -> [a]
shift (x:xs) = xs ++ [x]

--53 a)

--52
--import Prelude hiding (maximum)

maximum1 :: Ord a => [a] -> a
maximum1 xs = foldr1 max xs  -- completar esta definição

--55

-- completar esta definição
-- definir m.d.c. usando a função until
-- until :: (a -> Bool) -> (a -> a) -> a -> a
-- mdc a b = if b==0 then a else mdc b (a`mod`b)

mdc :: Integer -> Integer -> Integer
mdc a b = finalize (until endState nextState (a,b))
	where
		finalize (a,b)  = a
		endState (a,b)  = b == 0
		nextState (a,b) = (b,a`mod`b)

-- 57
factorials :: [Integer]
factorials = 1:(zipWith (*) factorials [2..]) 

fibs :: [Integer]
fibs = 1:1:(zipWith (+) fibs (tail fibs))

--58
pot2 :: [Integer]
pot2 = 1 : map(*2) pot2 
--pot2 = 1:[x*2 | <- pot2]
--b) lista infinita de potencias de 3
pot3 :: [Integer]
pot3 = 1 : map(*3) pot3
--c) lista infinita de potencias de 5
pot5 :: [Integer]
pot5 = 1 : map(*5) pot5

mrge :: [Integer] -> [Integer] -> [Integer]
mrge (x:xs) (y:ys)  | x<y = x:mrge xs (y:ys)
                    | x>y = y:mrge (x:xs) ys
                    | otherwise = x : mrge xs ys

haming :: [Integer]
haming = 1:(mrge l1 (mrge l2 l3))
       where l1 = map (*2) haming
             l2 = map (*3) haming 
             l3 = map (*5) haming

--60
-- completar esta definição
nextlinepascal :: [Integer] -> [Integer]
nextlinepascal l = [1] ++ [a + b | (a,b) <- zip l (tail l)] ++ [1]
--Cada linha começa com 1 e acaba com 1

pascal :: [[Integer]]
pascal = [1] : map (nextlinepascal) pascal
--Pega na lista pascal e aplica-lhe a lista nextLinepascal


--70
-- árvores binárias 
data Arv a = Vazia | No a (Arv a) (Arv a)
           deriving (Eq,Show)

testeArv :: Arv Int
testeArv = No 2 (No 1 Vazia Vazia) (No 3 Vazia (No 4 Vazia Vazia))

sumArv :: Num a => Arv a -> a
sumArv Vazia = 0
sumArv (No v esq dir) = v + (sumArv esq) + (sumArv dir)

--71

listarDecr :: Arv a -> [a]
listarDecr Vazia = []
listarDecr (No v esq dir) = (listarDecr dir) ++ [v] ++ (listarDecr esq)

--72

nivel :: Int -> Arv a -> [a]
nivel _ Vazia = []
nivel 0 (No v esq dir) = [v]
nivel n (No v esq dir) = (nivel (n-1) esq) ++ (nivel (n-1) dir)

--76

remover :: Ord a => a -> Arv a -> Arv a
remover x Vazia = Vazia
remover x (No y Vazia dir) | x == y = dir
remover x (No y esq Vazia) | x == y = esq
remover x (No y esq dir)   | x < y = No y (remover x esq) dir
                           | x > y = No y esq (remover x dir)
                           | x == y = let z = mais_dir esq
                                      in No z (remover z esq) dir


mais_dir :: Arv a -> a
mais_dir (No x _ Vazia) = x
mais_dir (No _ _ dir) = mais_dir dir


