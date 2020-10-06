{- exercicio 1
 a)
	inc (quadrado 5)
		|-> quadrado 5 = 25
		|-> inc 25 = 26
b)
	quadrado(inc 5)
		|-> inc 5 = 6
		|-> quadrado 6 = 36
c)
	media(dobro 3)(inc 5)
		|-> dobro 3 = 6 && inc 5 = 6
		|-> media 5 6 = 5.5
(CHECK)
-}
-- TESTE: 
inc x = x + 1
dobro x = x + x
quadrado x = x*x
media x y = (x + y)/2

-- exercicio 2
triangulo a b c= a<c+b && b<a+c && c<b+a
-- exercicio 3
perimetro a b c = (a+b+c)/2
area a b c = sqrt(s*(s-a)*(s-b)*(s-c))
			 where s = perimetro a b c 
-- ou 
area1 a b c = let s = perimetro a b c in
 			 sqrt(s*(s-a)*(s-b)*(s-c))

-- exercicio 4
metades :: [a]->([a],[a])
metades xs = let s = length xs in
			 let s2 = s`div`2 in -- ou div(s 2)
			 (take s2 xs,drop s2 xs)
{- Metades [1,2,3,4,5,6]
	|-> s=6
	|-> s2= 6`div`2
	|->(take 3 [1,2,3,4,5,6],drop 3 [1,2,3,4,5,6])
	|->([1,2,3],[4,5,6])
-}
-- exercicio 5
-- a)
last1 :: [a]->a
last1 xs = head(reverse xs)
{-|-> [1,2,3,4]->[4,3,2,1]
  			   ->4 -}

last2 :: [a]->a
last2 xs = head(drop(length xs-1) xs)
{- [1,2,3,4]-> [4]
            ->  4-}

last3 :: [a]->a
last3 xs = xs !! (length xs-1)
--	  [1,2,3,4]->4

-- b)
init1 :: [a]->[a]
init1 xs = take(length xs-1) xs

init2 :: [a]->[a]
init2 xs = reverse(drop 1(reverse xs))
{-|-> [1,2,3,4] -> [4,3,2,1]
   -> [3,2,1]  -> [1,2,3]-}

init3 :: [a]->[a]
init3 xs = reverse(tail(reverse xs))

-- exercicio 6
factorial n = product[1..n]
binom n k = let f n=factorial n in 
			f(n)/(f k *f (n-k))
-- não definir let de uma função

-- exercicio 7
-- a)
max1 x y = if x > y then x else y
min1 x y = if x < y then x else y

max3 a b c = if a >= max1 b c then a else max1 b c
min3 a b c = if a <= min1 b c then a else min1 b c

-- b)
max4 a b c = max1 (max1 a b) c
min4 a b c = min1 (min1 a b) c

--exercicio 8
--a)
maxOccurs :: Integer -> Integer ->(Integer,Integer)
maxOccurs a b
            |a == b = (a,2)
            |otherwise = (max a b, 1)

orderTripple :: Ord a => (a,a,a) -> (a,a,a)
orderTripple (x,y,z)    | x >= y && y >= z = (z,y,x)
                        | x >= z && z >= y = (y,z,x)
                        | y >= x && x >= z = (z,x,y)
                        | y >= z && z >= x = (x,z,y)
                        | z >= x && x >= y = (y,x,z)
                        | otherwise = (x,y,z)

--Exercicio 9
classifica :: Int -> String
classifica a    |a <= 9 = "reprovado"
                |a >= 10 && a <= 12 = "suficiente"
                |a >= 13 && a <= 15 = "bom"
                |a >= 16 && a <= 18 = "muito bom"
                |otherwise = "excelente"

--Exercicio 10
xor :: Bool -> Bool -> Bool
xor x y |x/=y = True
        |otherwise = False

--Exercicio 11
safetail1 :: [a] -> [a]
safetail1 [] = []
safetail1 (x:xs) = xs

--Exercicio 12
--a)
curta :: [a] -> Bool
curta l = if length l < 3 then True else False

