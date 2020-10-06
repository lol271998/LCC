-- Exercicio 22
soma :: Integral a => a -- O haskell escolhe o tipo consoante o output
soma = sum[x^2 | x<-[1..100]]

--Exercicio 23
--a)
aprox :: Int -> Double
aprox n = 4.0*(sum[fun x | x <-[0..n]])
fun  x = ((-1.0)^x)/(fromIntegral((2*x+1)))	
--b)
aprox' :: Int -> Double
aprox' n = sqrt(12.0*(sum[(((-1.0)^k)/(fromIntegral((k+1)^2)))|k<-[0..n]]))

--Exercicio 24
divprop :: Int -> [Int]
divprop n = [x | x<-[1..n`div`2]{-Cria a lista, até n/2-}, n`mod`x==0] --Cria a lista com os divores próprios

-- Exercicio 25
perfeitos :: Int -> [Int]
perfeitos n = [x | x<-[1..n], sum(divprop x) == x]

--Exercicio 26
primo:: Int -> Bool
primo n = divprop n == [1]

--Exercicio 27
factorial n = product[1..n]
binom n k = let f n=factorial n in 
			f(n)`div`(f k *f (n-k))

linha  :: Int->[Int]
linha n = [binom (n-1) k | k<-[0..(n-1)]]

pascal :: Int->[[Int]]
pascal n = [linha x | x<-[1..n]]

{--Exercicio 28
dotprod :: [Float]->[Float]->Float
dotprod xs ys = sum[x*y | (x,y)<-zip xs ys]
-}

