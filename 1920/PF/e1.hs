-- e2
triangulo :: Int-> Int-> Int -> Bool
triangulo a b c = if a+b>c && a+c>b && b+c>a then True else False

--e3

area :: Float->Float->Float->Float
area a b c = sqrt(s*(s-a)*(s-b)*(s-c))
       	     where s = (a+b+c)/2

--e4

metades l = (l1,l2)
          where l1 = take ((length l) `div` 2) l
	  	l2 = drop ((length l) `div` 2) l

metades1 l = (l1,l2)
	   where l1 = take n l
	   	 l2 = drop n l
		 n  = (length l) `div` 2

--e5

--a)
last1 l = l1
      where l1 = head(drop((length l)-1) l)

last2 l = l1
      where l1 = head(reverse l)

--b)
init1 l = l1
      where l1 = take ((length l)-1) l

init2 l = l1
      where l1 = reverse(drop 1 (reverse l))


--e6

--a)
binom1 :: Float->Float->Float
binom1 n k = (product[1..n]/((product[1..k])*(product[1..x])))
       	   where x = n-k
{-
--b)
product(x++y) =
-}

--e7
--a)

max1 x y = if x>=y then x else y
min1 x y = if x<=y then x else y

max3 :: Int-> Int-> Int-> Int
max3 x y z = if (max x y)<=z then z else (max x y)

min3 :: Int->Int->Int->Int
min3 x y z = if (min x y)>=z then z else (min x y)

--b)

max3a x y z = max x (max y z)
min3a x y z = min x (min y z)

--e8

maxOccurs :: Integer->Integer->(Integer,Integer)
maxOccurs x y = ((max x y),c)
	      where c = if x == y then 2 else 1

m :: Int->Int->Int->Int
m x y z = |x != (max3 x y z) =  x
      	  |y != (max3 x y z) =  y
    	  |otherwise z

orderTripple :: (Integer,Integer,Integer) -> (Integer,Integer,Integer)
orderTripple (x,y,z) = (min3 x y z, m x y z, max3 x y z   	   