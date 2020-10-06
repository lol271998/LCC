import stack.hs
-- Exercicio 79
-- a)
data Shape =
      Circle Float
    | Rectangle Float Float

perimetro :: Shape -> Float
perimetro (Circle n) = 2*pi*n
perimetro (Rectangle a b) = 2*a + 2*b

-- Exercicio 80
type Ponto = (Float,Float)
type Rectangle1 = (Ponto,Ponto)

area :: Rectangle1 -> Float
area((x,y),(x',y')) = abs(x-x') * abs(y-y')

{-
intersectam :: Rectangle1 -> Rectangle1 -> Bool
intersectam ((x1,y1),(x1',y1')) ((x2,y2),(x2',y2')) =
            x2>=x1 && y1'>=y2' && y1>=y2 && x2'>=x2 
-}

{-
area1 :: Rectangle1 -> Float
area1 (p1,p2,p3,p4) = distancia p1 p3 * distancia p2 p4
-}

-- Exercicio 81
{-
parent' :: String -> Stack Char -> Bool
parent' [] stk = isEmpty stk
parent' (c:cs) stk = if c == '(' || c == '[' || c == '{' then
                        parent' cs (push c stk)
                        else
                            if c == ')' then
                                if top stk == '(' then
                                    parent' cs(pop stk)
                                else False
                            else if c == ']' then
                                if top stk == '[' then
                                    parent' cs(pop stk)
                                else False
                            else if top stk == '{' then
                                    parent' cs (pop stk)
                                else False

parent :: String -> Bool
parent s = parent' s empty
-}


calc :: Stack Float -> String -> Stack Float
calc stk = if isOperator s then
              let x = top stk in
              let y = top (pop stk) in
              push(eval s x y) (pop(pop stk))
           else let x = read s :: Float in
                push x stk