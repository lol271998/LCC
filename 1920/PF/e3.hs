--22)
soma = sum [x*x|x<-[1..100]]

--23)
--a)
aprox :: Int->Double
aprox n = 4 * sum [((-1)^x)/(fromIntegral(2*x+1))|x<-[0..n-1]]

--b)
aprox' :: Int->Double
aprox' n = sqrt(12* sum [(-1)^x/fromIntegral((x+1)^2)|x<-[0..n-1]]) 

--24)
divprop :: Int -> [Int]
divprop n = [x | x<-[1..n-1], n`mod`x == 0]

--25)
perfeitos :: Int -> [Int]
perfeitos n = [x | x<-[2..n], sum (divprop x) == x]

--26)
primo :: Int -> Bool
primo n = if(length(divprop n) == 1) then True else False

--27)
binom1 :: Int->Int->Int
binom1 n k = (product[1..n]`div`((product[1..k])*(product[1..x])))
           where x = n-k

pascal :: Int->[[Int]]
pascal linha = [[binom1 n k | k<-[0..n] ]|n<-[0..linha]]

--28)
dotprod :: [Float] -> [Float] -> Float
dotprod l1 l2 = sum [ a*b | (a,b) <- zip l1 l2]

--29)
pitagorico :: Int->[(Int,Int,Int)]
pitagorico n = [(x,y,z)| x<-[1..n],y<-[1..n],z<-[1..n], (x^2 + y^2 == z^2)]

--30)
maisoito :: String -> Bool
maisoite str = if(length str < 8) then False else True

maius :: String -> Bool
maius str = if()

forte :: String -> Bool 
forte str = if (maisoito str) && (maius str) && (minus str) then True else False