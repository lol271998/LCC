
removeElemento x l = [ y | y<-l, x /= y ]

--37
nub :: Eq a => [a] -> [a]
nub [] = []
nub (x:xs) = [x] ++ (nub(removeElemento x xs))

--38
interperse' :: a -> [a] -> [a]
interperse' c [] = []
interperse' c (x:[]) = (x:[])
interperse' c (x:xs) = (x:c:(interperse' c xs))

--39
maxFun :: (Integer -> Integer) -> Integer -> Integer
maxFun f 0 = f 0
maxFun f n = max (f n) (maxFun f (n-1))

adiciona4 :: Integer -> Integer
adiciona4 n = n + 4

--40
anyZero :: (Integer -> Integer) -> Bool
anyZero f 


--45
bits 0 = []
bits n = [(False:x) | ] ++ [(True:x) ]
