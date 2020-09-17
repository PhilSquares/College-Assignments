{- ###########################
	Phillip Squarcetta
	2/6/2020
	Homework 1
   ########################### -} 

module Prog1 where 

-- isPositive checks if some float number n is greater than 0. 
isPositive :: Float -> Bool  
isPositive n 
  | n > 0  = True
  | otherwise = False 

-- dividesEvenlyByFive takes an Integer number and checks if it can divide by 5 evenly using infix `mod`. 
dividesEvenlyByFive :: Integer -> Bool 
dividesEvenlyByFive m = m `mod` 5 == 0

-- middle takes into account all possible variations below to find the middle Integer (p k and s). 
middle :: Integer -> Integer -> Integer -> Integer
middle p k s 
  | (p >= k) && (k >= s) = k  
  | (p <= k) && (p <= s) = p  
  | (p >= k) && (k <= s) = k 
  | otherwise = s

  -- nor meaning not or TT with return F and FF will return T.
nor :: Bool -> Bool -> Bool 
nor p k = not(p || k)

-- Use fromIntegral to convert to float and include 1/2 base * height
triangleArea :: Integer -> Integer -> Float 
triangleArea b c = (fromIntegral b * fromIntegral c) / 2

-- Rounds number to highest value (6.7 to 7.0)
ceilingDecimal :: Float -> Float 
ceilingDecimal b1 = fromInteger(ceiling b1)

-- Test the final grade received based on the grading policy given on website
letterGrade :: Integer -> String 
letterGrade x 
  | (x <= 100) && (x >= 93) = "A"
  | (x >= 90) && (x <= 92) = "A-"
  | (x >= 87) && (x <= 89) = "B+"
  | (x >= 83) && (x <= 86) = "B"
  | (x >= 80) && (x <= 82) = "B-"
  | (x >= 77) && (x <= 79) = "C+"
  | (x >= 73) && (x <= 76) = "C"
  | (x >= 70) && (x <= 72) = "C-"
  | (x >= 67) && (x <= 79) = "D+"
  | (x >= 63) && (x <= 66) = "D"
  | (x >= 60) && (x <= 62) = "D-"
  | (x <= 60) && (x >= 0) = "F"
  | otherwise = "Out of bounds"

  -- fromIntegral converts to a float to average values placed in for h i and j by user. 
averageThree :: Integer -> Integer -> Integer -> Float 
averageThree h i j = fromIntegral(h + i + j) / 3

-- Started by stating if all are equal then output is 0. Next, I tested all possibilities for returning 2. 
-- We know it can't be 3 because it's not possible to have 3 numbers above average. 
-- Lastly, we check for the only possibility left which is 1. 
howManyAboveAverage :: Integer -> Integer -> Integer -> Integer 
howManyAboveAverage a b c 
  | (a == b && b == c) = 0
  | (fromIntegral a > (averageThree a b c)) && (fromIntegral b > (averageThree a b c)) = 2
  | (fromIntegral b > (averageThree a b c)) && (fromIntegral c > (averageThree a b c)) = 2
  | (fromIntegral a > (averageThree a b c)) && (fromIntegral c > (averageThree a b c)) = 2
  | otherwise = 1

-- z < is checking to see if its not within threshold = 0
-- z > is saying it would fall within the threshold.
-- fromIntegral takes an int and turns into a float. To compare a - averageThree, we need both to be float values.    
howManyWithinThreshold :: Integer -> Integer -> Integer -> Float -> Integer
howManyWithinThreshold a b c z
  | (z < abs(fromIntegral a - (averageThree a b c))) && (z < abs(fromIntegral b - (averageThree a b c))) && (z < abs(fromIntegral c - (averageThree a b c))) = 0
  | (z > abs(fromIntegral a - (averageThree a b c))) && (z > abs(fromIntegral b - (averageThree a b c))) && (z > abs(fromIntegral c - (averageThree a b c))) = 3
  | (z > abs(fromIntegral a - (averageThree a b c))) && (z > abs(fromIntegral b - (averageThree a b c))) = 2
  | (z > abs(fromIntegral a - (averageThree a b c))) && (z > abs(fromIntegral c - (averageThree a b c))) = 2
  | (z > abs(fromIntegral b - (averageThree a b c))) && (z > abs(fromIntegral c - (averageThree a b c))) = 2
  | otherwise = 1













