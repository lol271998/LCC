-- Exercicio 71
data Arv a = Vazia | No a (Arv a) (Arv a)
            deriving(Read,Show)

sumArv :: Num a => Arv a -> a
sumArv Vazia = 0
sumArv (No x e d) = x + sumArv e + sumArv d

arv1 = No 1 Vazia Vazia
arv2 = No 4 (No 2(No 1 Vazia Vazia)(No 3 Vazia Vazia))(No 6(No 5 Vazia Vazia) Vazia)

-- Exercicio 72

listar :: Arv a -> [a]
listar Vazia = []
listar (No x e d) = listar e ++ [x] ++ listar d

-- Exercicio 72
nivel :: Int -> Arv a -> [a]
nivel _ Vazia = []
nivel 0 (No x e d) = [x]
nivel n (No x e d) = nivel(n-1) e ++ [x] ++nivel(n-1) d

-- Exercicio 74 (Casa)

-- Exercicio 75

mapArv :: (a->b)->Arv a -> Arv b
mapArv _ Vazia = Vazia
mapArv f (No x e d) = No (f x) (mapArv f e)
                               (mapArv f d)

