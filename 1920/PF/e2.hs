-- Aula 2
--14
--a) [Char]
--b) (Char,Char,Char)
--c) [(Bool,Char)]
--d) ([Bool],[Char])
--e) [[a]->[a]]
--f) [Bool->Bool] //Tipo mais restrito

--15
--1) f :: (Int,Int)->Int
--2) f :: Int->Int
--   g :: Int->Int
--   ou 
--   f :: a->Int
--   g :: Int->a

--3) f::()
--17
--a)    
segundo :: [a]->a
segundo xs = head(tail xs)
--b)
trocar :: (a,b)->(b,a)
trocar (x,y) = (y,x)
--c)
par :: a -> b ->(a,b)
par x y = (x,y)
--d)
dobro :: Num a => a -> a
dobro x = 2*x 
--e)
metade :: Fractional a => a -> a
metade x = x/2
--f)
minuscula :: Char -> Bool
minuscula x = x>='a' && x<='z' --O x tem que ser caracter, pois vai ser comparado com caracteres

--g)
intervalo :: Ord a => a -> a -> a -> Bool
intervalo x a b = x>=a && x<=b

--h)
palindromo :: Eq a => [a]->Bool
palindromo xs = reverse xs == xs

--i)
--twice :: (a->a)->a->a
twice f x = f(f x)
-- f :: a-> a // x:: a

--18
--Tipos admissiveis
{-
    inc :: Int->Int
    dobro :: Int->Int
    quadrado :: Int->Int
    media :: Double -> Double -> Double
    triangulo :: Int-> Int-> Int -> Bool
    triangulo a b c = if a+b>c && a+c>b && b+c>a then True else False    

-}
-- Tipos gerais
inc :: Num a => a -> a
inc x = x + 1

dobro1 :: Num a => a -> a
dobro1 x = x+x

quadrado :: Num a => a -> a
quadrado x = x*x

media :: Fractional a => a -> a -> a
media x y = (x+y)/2

triangulo :: (Num a,Ord a) => a -> a -> a ->Bool
triangulo a b c = if a+b>c && a+c>b && b+c>a then True else False

--19
