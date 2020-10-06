h::[Int] -> Int
h[] = 1
h[x] = x
h(x:y:xs) = x*y + h(y:xs)

f x xs = sum xs < x

diferentes :: [Int] -> [Int]
diferentes xs = [ x | (x,y) <- zip xs (tail xs),x/=y]

zip3 :: [a] -> [b] -> [c] -> [(a,b,c)]
zip3 xs ys zs = [(x,y,z)|(x,(y,z)) <- zip xs (zip ys zs)]

{-
parts :: [a] -> [[a]]
parts [] = [[]]
parts xs =[(take n xs) : ps | n <- [1..length xs],ps<-parts(drop n xs)]
-}

maius :: String -> Bool
maius [] = False
maius (h:hs) = if(h>='A' && h<='Z') then True else maius hs

mini :: String -> Bool
mini [] = False
mini (h:hs) = if(h>='a' && h<= 'z') then True else mini hs

alpha :: String -> Bool
alpha [] = False
alpha (h:hs) = if(h>='0' && h<= '9') then True else alpha hs

forte :: String -> Bool
forte str = if length str>=6 && and[maius str,mini str, alpha str] then True else False

pitagoricos :: Int -> Int -> Int -> Bool
pitagoricos a b c | (a*a) + (b*b) == (c*c) = True
				  | (b*b) + (c*c) == (a*a) = True
				  | (c*c) + (a*a) == (b*b) = True
				  |	otherwise = False

zip3' :: [a] -> [b] -> [c] -> [(a,b,c)]
zip3' xs ys zs = [(x,y,z) | (x,(y,z)) <- zip xs(zip ys zs)]

rfc :: [[Float]] -> Int
rfc xs = sum [1 | ys <- xs, any(<8) ys]

factorials = 1:(zipWith (*) factorials [2..])

fibs = 1:1:(zipWith (+) fibs (tail fibs))

imparDiv3 :: [Int] -> Bool
imparDiv3 l = and [odd x | x <- l,  x`mod`3 == 0]