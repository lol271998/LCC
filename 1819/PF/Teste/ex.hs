f :: [Int] -> Int
f [] = 1
f [x] = x
f (x:xs) = x + f xs

