{- ###########################
	Phillip Squarcetta
	2/10/2020
	Homework 2
   ########################### -} 

   module Prog2 where

-- (not) compares all values. If any two are equal to eachother returns false. 
threeDifferent :: Integer -> Integer -> Integer -> Bool 
threeDifferent x y z = (not)(x == y || y == z || x ==z) 

-- Use threeDifferent from previous and compare c and d values.   
fourDifferent :: Integer -> Integer -> Integer -> Integer -> Bool 
fourDifferent a b c d = (threeDifferent a b c) && (threeDifferent a b d) && (c /= d)

-- Any number inputed in ghci will sum up all values (Ex: sum' 4 = 1+2+3+4 = 10)
sum' :: Integer -> Integer
sum' n
  | n == 1 = n
  | n > 0 = sum'(n-1) + n

asciisum :: String -> Integer
asciisum [] = 0
asciisum (x:xs) = toInteger(fromEnum x) + asciisum xs

-- sqrt only takes a float value so we need fromIntegral
integerSqrt :: Integer -> Integer 
integerSqrt x = floor(sqrt(fromIntegral x))

maxThree :: (Integer, Integer, Integer) -> Integer
maxThree (x,y,z)
 | x >= y && x >= z                = x
 | y >= x && y >= z                = y
 | otherwise                       = z

midThree :: (Integer, Integer, Integer) -> Integer
midThree (x,y,z)
 | (x >= y && x <= z) || (x <= y && x >= z) = x
 | (y >= x && y <= z) || (y <= x && y >= z) = y
 | otherwise                        = z

 
minThree :: (Integer, Integer, Integer) -> Integer
minThree (x,y,z)
 | x <= y && x <= z                = x
 | y <= x && y <= z                = y
 | otherwise                       = z

 -- Recursive call on all three functions from above. 
orderTriple :: (Integer, Integer, Integer) -> (Integer, Integer, Integer)
orderTriple x =(minThree x, midThree x, maxThree x)

-- swaps value over one.
swap :: (Char, Char, Char, Char) -> (Char, Char, Char, Char) 
swap (a, b, c, d) = (b, a, d, c)

-- returns negative values of two digits.
negateTwoDigits :: [Integer] -> [Integer] 
negateTwoDigits xs = [negate x | x <- xs, x > 9, x < 100]

-- Creates a list and injects into a new list and picks out all instances of an integer n from a list
-- Integer = a   [Integer] = b   [Integer] = n
matches :: Integer -> [Integer] -> [Integer]
matches a b = [n | n <- b, n == a]

-- Checks if element is in the list. 
element :: Integer -> [Integer] -> Bool
element a b
  | length (matches a b) == 0         = False
  | otherwise                         = True




