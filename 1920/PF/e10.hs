--70

data Arv a = Vazia | No a (Arv a) (Arv a)

testeArv :: Arv Int
testeArv = No 8(No 5 (No 3 Vazia Vazia) Vazia) (No 10(No 9 Vazia Vazia) (No 15 Vazia Vazia))

--[3,5,8,9,10,15]

--                  8
--        5                   10
--    3       x           9        15
--  x   x   x   x       x   x    x    x

contaArv :: Arv a -> Int
contaArv Vazia = 0
contaArv (No v esq dir) = 1 + (contaArv esq) + (contaArv dir)

--70
sumArv :: Num a => Arv a -> a
sumArv Vazia = 0
sumArv (No v esq dir ) = v + (sumArv esq) + (sumArv dir)

--71
listar :: Arv a -> [a]
listar Vazia = []
listar (No x esq dir) = (listar dir) ++ [x] ++ (listar esq)

--72
nivel :: Int -> Arv a -> [a] 
nivel _ Vazia = []
nivel 0 (No v esq dir) ++ [v]
nivel n (No x esq dir) = (nivel (n-1) esq) ++ (nivel (n-1) dir)

--73
--a)
construir :: [a] -> Arv a
construir [] = Vazia
construir xs = No x (construir xs') (construir xs'')
			 where n = length xs `div` 2
			 	   xs' = take n xs
			 	   x:xs'' = drop n xs

--b)
inserir :: Ord a => a -> Arv a -> Arv a
inserir x Vazia = No x Vazia Vazia
inserir x (No y esq dir) | (x==y) = (No y esq dir)
						 | (x < y) = (No y(inserir x esq) dir)
						 | (x > y) = (No y esq (inserir x dir))