--Impares
--[1,3,5,7,9,..]

--1º Descrição infinita do são impares
--2º pegar nos primeiros 10

-- take 10 [1,3..]
-- [1,3,5,7,9,11,13,15,17,19]

-- [1,3..]

impares :: [Int]
impares = 1 : [n+2|n<-impares]

-- [1]
-- [1,3]  		[n+2 | n<- [1,??]] 		n = 1
-- [1,3,5] 		[n+2 | n<- [1,3,??]] 	n = 3
-- [1,3,5,7] 	[n+2 | n<- [1,3,5,??]]	n = 5

--57
--factorial = [1,1,2,6,24,120,720,..]
-- 1	1*1		1*2		1*2*3
factorial :: [Int]
factorial = 1 : [a*b |(a,b) <- zip factorial [1..]]

fact :: [Int]
fact = 1 : (zipWith (*) fact [1..])

-- [1]			1:[]
-- [1, 1]		[a*b |(a,b) <- zip [1,?] [1,?]] a = 1 b = 1
-- [1, 1, 2]	[a*b |(a,b) <- zip [1,1,??] [1,2,..]] a = 1 b = 2
-- [1, 1, 2, 6] [a*b |(a,b) <- zip [1,1,2,??] [1,2,3..]] a = 2 b = 3

--fibonacci = [0,1,1,2,3,5,8,13,21,..]
fibonacci :: [Int]
fibonacci = 0:1:[x+y | (x,y) <- zip fibonacci (tail fibonacci)]

-- [0]
-- [0, 1]
-- [0, 1, 1]		[x+y | (x,y) <- zip [0,1] 1]	x = 0 y = 1
-- [0, 1, 1, 2]		[x+y | (x,y) <- zip [0,1,1] 1]	x = 1 y = 2
-- [0, 1, 1, 2, 3]	[x+y | (x,y) <- zip [0,1,1,2] 2]	x = 1 y = 2

--58
--a) lista infinita de potencias de 2
pot2 :: [Int]
pot2 = 1 : map(*2) pot2 
--pot2 = 1:[x*2 | <- pot2]
--b) lista infinita de potencias de 3
pot3 :: [Int]
pot3 = 1 : map(*3) pot3
--c) lista infinita de potencias de 5
pot5 :: [Int]
pot5 = 1 : map(*5) pot5
--d) Função merge que merge duas listas infinitas, mantendo a ordem
-- remove duplicados
merge :: [Int] -> [Int] -> [Int]
merge (x:xs) (y:ys) | x < y = x : merge xs (y:ys)
                    | x > y = y : merge (x:xs) ys
                    | otherwise = x : merge xs ys

--e) Função que apresenta os numeros de haming
haming :: [Int]
haming = 1:(merge l1 (merge l2 l3))
       where l1 = map (*2) haming
             l2 = map (*3) haming 
             l3 = map (*5) haming

-- [1,2,3,4,5,6,8,9,10]

--[1]       l1 = [2]    l2 = [3]    l3 = [5] (fica o primeiro, porque é o menor)
--[1,2]     l1 = [2,4]  l2 = [3,6]  l3 = [5,10]

somas :: [Int] -> [Int]
somas l = 0 : zipWith(+) l (somas l)
--somas l = 0 : [x + y | (x,y) <- zip l (somas l)] 

-- [1,3,..]
-- [0]
-- [0, 1]        [x + y | (x,y) <- zip [1] [0]]
-- [0, 1, 4]     [x + y | (x,y) <- zip [1,3] [0,1]]
-- [0, 1, 4, 9]  [x + y | (x,y) <- zip [1,3,5] [0, 1, 4]]

-- 60

nextPascal :: [Int] -> [Int]
nextPascal l = [1]++ [a + b | (a,b) <- zip l (tail l)] ++ [1]

--nextPascal :: [Int] -> [Int]
--nextPascal [1,1] = [1,2,1]
--nextPascal [1,2,1] = [1,3,3,1]
--                          1                  [1]
--                     1         1             [1,1]
--                 1        2        1         [1,2,1]
--             1       3         3       1     [1,3,3,1]

pascal :: [[Int]]
pascal = [1] : map (nextPascal) pascal

--[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]


shift :: [a] -> [a]
shift [] = []
shift (x:xs) = xs ++[x]

rotate :: [a] -> [[a]]
rotate l = take (length l) (iterate shift l)

--rotate [1,2,3] = [[1,2,3],[2,3,1],[3,1,2]]

lowerCases :: [Char]
lowerCases = "abcdefghijklmnopqrst"
    




