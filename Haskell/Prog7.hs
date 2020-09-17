{- ##################################
 Phillip Squarcetta
 Homework 7.
 ################################## -}
module Prog7 where

data Expr = Val Int
 | Add Expr Expr
 | Sub Expr Expr
 | Mul Expr Expr
 | Div Expr Expr
 
eval :: Expr -> Int
eval (Val n)     = n
eval (Add e1 e2) = eval e1 + eval e2
eval (Sub e1 e2) = eval e1 - eval e2
eval (Mul e1 e2) = eval e1 * eval e2
eval (Div e1 e2) = eval e1 `div` eval e2 

maxlit :: Expr -> Int
maxlit (Val x) = x
maxlit (Add x y) = maximum(maxlit x : maxlit y : [])
maxlit (Sub x y) = maximum(maxlit x : maxlit y : [])
maxlit (Mul x y) = maximum(maxlit x : maxlit y : [])
maxlit (Div x y) = maximum(maxlit x : maxlit y : [])

safeeval :: Expr -> Maybe Int
safeeval (Val n) = Just n
safeeval (Add e1 e2) =
         case safeeval e1 of
         Nothing -> Nothing
         Just x -> case safeeval e2 of
          Nothing -> Nothing
          Just y -> Just (x + y)
safeeval (Div x (Val 0)) = Nothing
-- How to run: safeeval(Div(Val 5)(Val 0))

-- show :: Expr -> String
e1, e2, e3 :: Expr
e1 = Val 5
e2 = Add (Val 3) (Val 2)
e3 = Add (Val 3) (Mul (Val 2) (Val 4))
instance Show Expr where
    show (Val x) = show x
    show (Add x y) = "(" ++ show x ++ "+" ++ show y ++ ")"
    show (Sub x y) = "(" ++ show x ++ "-" ++ show y ++ ")"
    show (Mul x y) = "(" ++ show x ++ "*" ++ show y ++ ")"
    show (Div x y) = "(" ++ show x ++ "/" ++ show y ++ ")"


addone :: Expr -> Expr
addone (Val x) = Val (x+1)
addone (Add x y) = Add(addone x) (addone y)
addone (Sub x y) = Sub(addone x) (addone y)
addone (Mul x y) = Mul(addone x) (addone y)
addone (Div x y) = Div(addone x) (addone y)

containing :: Eq a => [a] -> [a] -> Bool
containing x [] = False
containing [] y = True
containing (x:xs) y
  | x `elem` y = containing xs y
  | otherwise  = False

sumSqNeg :: [Int] -> Int
sumSqNeg xs = foldr (+) 0 (map (^2) (filter (<0 ) xs))

lengths :: [String] -> [Int]
lengths xs = map length xs

total :: (Int -> Int) -> [Int] -> Int
total f x = sum (map f x)

containing' :: Eq a => [a] -> [a] -> Bool
containing' _ [] = False
containing' xs ys = foldr (&&) True (map elem' xs)
   where
      elem' z
       |z `elem` ys      = True
       |otherwise        = False