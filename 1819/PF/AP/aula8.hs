-- Exercicio 58
fibonacci :: [Integer]
fibonacci = 0:1:[n+m|(n,m)<- zip fibonacci(tail fibonacci)]

-- Exercicio 
factorial :: [Integer]
factorial = 1:[n*m|(n,m) <- zip factorial[1..]]
{-
Passos:
    1<-(1,1)<- zip(1:[...]) ([1,2,3,4..])
    2<-(1,2)<- zip(1:[...]) ([2,3,4..])
    6<-(2,3)<- zip(2:[...]) ([3,4..])
   24<-(6,4)<- zip(6:[...]) ([4..])
-}

-- Exercicio 59
merge :: Ord a => [a]->[a]->[a]
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys) | x == y = x:merge xs ys
                    | x <= y = x:merge xs(y:ys)
                    | otherwise = y:merge(x:xs) ys

base2 = map(2^) [0..]
base3 = map(3^) [0..]
base5 = map(5^) [0..]

hamming :: [Integer]
hamming = merge b2(merge b3 b5)
        where b2 = merge base2(merge(map(3*)base2)(map(5*)base2))
              b3 = merge base3(merge(map(2*)base3)(map(5*)base3))
              b5 = merge base5(merge(map(2*)base5)(map(3*)base5))


-- Exercicio 60
somas :: [Int] -> [Int]
somas xs = scanl (+) 0 xs

{-
    scanl (+) 0 [1,2,3,4] | foldl (+) 0 [1,2,3,4]=10
                            (((0+1)+2)+3)+4
    [0,1,3,6,10]            ((1+2)+3)+4
                            (3+3)+4
                            6+4
-}

-- Exercicio 61
factorial1 n = product[1..n]
binom n k = let f n=factorial1 n in 
            f(n)/(f k *f (n-k))

linha l = [binom(l-1)k | k<-[0..l-1]]


pascal = [linha x | x<-[0..]]

{-
binom1 :: Int -> Int -> Int
binom1 n 0 = 1
binom1 n k  | n == k = 1
            | otherwise = binom(n-1) (k-1) + binom(n-1) k
-}

-- Exercicio 63

shift :: [a]->[a]
shift [] = []
shift (x:xs) = xs++[x]

rotate :: [a] -> [[a]]
rotate xs = take(length xs) $ iterate shift xs