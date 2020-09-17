{- ###########################
	Phillip Squarcetta
	3/19/2020
	Homework 4
   ########################### -} 

module Prog4 where
import Data.Char

doubleAll :: [Int] -> [(Int, Int)] 
doubleAll [] = [] 
doubleAll (x:xs) = (x, x*2) : doubleAll xs

productLastPart :: Int -> [Int] -> Int
productLastPart n [] = 1
productLastPart n xs = last xs * productLastPart (n-1) (init xs)

{- [1,2,3,4] -> n = 3, last xs = 4, init xs = [1,2,3] -> 4 *
[1,2,3] -> n = 2, last xs = 3, init xs = [1,2] -> 4 * 3
[1,2] -> n = 1, last xs = 2, init xs = [1] -> 4 * 3 * 2
[1] -> n = 0, -> 4 * 3 * 2 * 1 -}

init' :: [Int] -> [Int] 
init' [x] = []
init' (x:xs) = x : init' xs

lowerOddLetters :: String -> String
lowerOddLetters [] = []
lowerOddLetters [x] = [toLower x] -- Brackets can be used bc String is a list of chars 
lowerOddLetters (x:y:ys) = toLower x : y : lowerOddLetters ys

{-1 2 3 4 5
H E L L O

x = H
y = E

L L O

x = L
y = L

O
x = O -} 

replicate' :: Int -> Char -> String 
-- If n is not 0, you're performing the recursive step. 
replicate' 0 c = []
replicate' n c = c : replicate' (n-1) c 


iSort' :: [(Int, String)] -> [(Int, String)]
iSort' [] = []
iSort' (x:xs) = ins' x (iSort' xs)

ins' :: (Int,String) -> [(Int, String)] -> [(Int, String)]
ins' (a,b) [] = [(a,b)]
ins' x (y:ys)
    |fst x < fst y   = x:y:ys -- Checking if sorted. If not do otherwise
    |otherwise       = y:ins' x ys
   
lowerFirstCharacter :: String -> String 
lowerFirstCharacter (x : xs) = if isUpper x then (toLower x : xs) else (x:xs)

middleWord :: String -> String
middleWord (x:xs)
  | (elem ' ' (x:xs)) == False   = (x:xs)
  | x == ' '                     = middleWord (reverse (xs))
  | otherwise                    = middleWord xs
-- west chester rocks
-- reverse(chester rocks)
-- reverse(reverse(chester))
-- chester 

lowerFirstLetter :: String -> String
lowerFirstLetter []         = []
lowerFirstLetter (x:xs)
  |isUpper x              = toLower x : xs ++ lowerFirstLetter []
  |otherwise              = x : lowerFirstLetter xs

lowerFirstTwoLetters :: String -> String
lowerFirstTwoLetters xs = lowerFirstLetter (lowerFirstLetter xs)



