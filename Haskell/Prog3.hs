
{- ###########################
	Phillip Squarcetta
	3/3/2020
	Homework 3
   ########################### -} 

module Prog3 where
import Data.Char

-- Takes a list of ints, and returns a list of pairs, such that the ﬁrst element in each pair is in the original number, 
-- and the second element is the original number doubled. 
-- [1,2,3,4] output would be [(1,1), (2,4), (3,9), (4,16)] 
doubleAll :: [Int] -> [(Int, Int)]
doubleAll x = [(y, y*2)| y <- x]

productLastPart :: Int -> [Int] -> Int 
productLastPart n b = product(take n(reverse b))

init' :: [Int] -> [Int] 
init' a = reverse(tail(reverse a))

nestedParens :: String -> Bool 
nestedParens x 
  -- | odd(length(x)) = False
  | x == "()" = True
  | (head x == '(') && (last x == ')') = nestedParens(tail(init x)) -- Takes everything from the middle. 
  | otherwise = False

triads :: Int -> [(Int,Int,Int)] 
triads n = [(x,y,z) | x <- [1..n], y <- [1..n], z <- [1..n], x^2 + y^2 == z^2] 

pushRight :: String -> Int -> String 
pushRight xs y 
  | y == 0   = xs
  | y > 0    = pushRight(" " ++ xs) (y-1) 

lowerFirstCharacter :: String -> String 
lowerFirstCharacter (x : xs) = if isUpper x then (toLower x : xs) else (x:xs)

-- Helper fn for middleword (1)
findSpace :: String -> [Int]
findSpace a = fst(unzip[s | s <- zip [0..length(a)-1] a, snd(s) == ' '])-- (1, 'b') 'b' is our a value. 

-- Helper fn for middleWord (2)
extractMiddle :: String -> Int -> Int -> String 
extractMiddle xs a' b' = snd(unzip[x | x <- zip [0..length(xs)-1] xs, fst x > a' && fst x < b'])

middleWord :: String -> String 
middleWord a = extractMiddle a (head(findSpace a)) (last(findSpace a))

-- Helper fn for lowerFirstLetter 
-- Gives list index [0] index of the first capital letter in the string. 
firstCapital :: [Char] -> Int
firstCapital x = head [a | (a, b) <- (zip [0..length x - 1] x), isUpper b]

lowerFirstLetter :: String -> String 
lowerFirstLetter xs = take (firstCapital xs) xs ++ lowerFirstCharacter (snd (splitAt (firstCapital xs) xs)) 
-- splitAt gives everything before and after the first capital letter. This is why (firstCapital xs) is present. 

lowerFirstTwoLetters :: String -> String 
lowerFirstTwoLetters x = lowerFirstLetter(lowerFirstLetter x) 
