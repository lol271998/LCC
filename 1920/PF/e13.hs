--Exercicio 82.1)

data Grafo = G ([Int],[(Int,Int)]) deriving Show

grafo82 :: Grafo
grafo82 = G ([1..6],[(1,2),(1,4),(2,3),(2,5),(2,6),(3,6),(4,5),(6,5)])

destinos :: Grafo -> Int -> [Int]
destinos (G(v,a)) o = [snd x | x <- a, fst x == o]

caminhos :: Grafo -> Int -> Int -> Int
caminhos (G(v,a)) o d | (o == d) = 1
                      | otherwise = sum [ caminhos (G (v,a) d | x<- dest]
                      where des = destinos (G,(v,a)) o           
