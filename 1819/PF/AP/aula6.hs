-- Exercicio 48
{-
[f x | x<- xs, p x] -> [f x | x<-xs] <=> map f xs
														-> map f(filter p xs)
					-> [x | x<-xs, p x] <=> filter p xs
-}
-- Exercicio 49
--a)
(+++):: [a] -> [a] -> [a]
(+++) [] ys = ys
(+++) (x:xs) ys = x:(+++) xs ys

foldr (\x acc:acc) ys xs 
--b)
concat :: [[a]] -> [a]
concat [] = []
concat (x:xss) = x ++ concat xss

foldr (\x acc -> x ++ acc) [] xss
--c)
reverse :: [a] -> [a]
reverse [] = []
reverse (x:xs) = reverse xs ++ [x]

foldr(\x acc -> acc ++ x) [] xs
--d)
foldl(\x acc -> x:acc) [] xs
--e)
elem1 :: Eq a => a -> [a] -> Bool
elem1 _ [] = False
elem1 e (x:xs)
        |e == xs = True
        |otherwise = elem e xs

elem2 x xs = any (== x) xs

