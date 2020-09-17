{- ###########################
	Phillip Squarcetta
	4/2/2020
	Homework 5
   ########################### -} 

   module Prog5 where

reverse' :: [a] -> [a] 
reverse' xs = case xs of
             []     -> []
             (y:ys) -> reverse' ys ++ [y]
{-
    "hello"
    reverse' "ello" ++ [h]
    reverse' "llo" ++ [e] ++ [h]
    [] ++ [o] ++ [l] ++ [l] ++ [e] ++ [h]
-}

isPalindrome :: String -> Bool 
isPalindrome str 
    |reverse' str == str    = True
    |otherwise              = False 

isLonger :: TimeStamp -> TimeStamp -> Int
isLonger (TimeStamp (h1,m1,s1)) (TimeStamp(h2,m2,s2))
  | h1 > h2  = -1
  | h2 > h1  = 1
  | m1 > m2  = -1
  | m2 > m2  = 1
  | s1 > s2  = -1
  | s2 > s1  = 1
  | otherwise = 0
data TimeStamp = TimeStamp (Int, Int, Int)
  deriving Show
-- A TimeStamp is a triple of Ints
-- How to test this: (TimeStamp (2,30,22)) (TimeStamp (3,30,22))
-- First checks hours, then minutes, then seconds (h1 h2, m1 m2, s1 s2)

totalSeconds :: TimeStamp -> Int
totalSeconds (TimeStamp (h, m, s)) = (h * 3600) + (m * 60) + s
-- TimeStamp is a Type Constructor 

isValid :: TimeStamp -> Bool 
isValid (TimeStamp (h1,m1,s1)) = (h1 >= 0) && (m1 >= 0 && m1 <= 59) && (s1 >= 0 && s1 <= 59)
 -- No more than 59 seconds and no more than 59 minutes. 

time2Str :: TimeStamp -> String
time2Str (TimeStamp (h, m, s))
   |isValid(TimeStamp (h, m, s)) && h < 10 && m < 10 && s < 10             = "0" ++ show h ++ ":" ++ "0" ++ show m ++ ":" ++ "0" ++ show s
   |isValid(TimeStamp (h, m, s)) && h < 10 && m < 10                       = "0" ++ show h ++ ":" ++ "0" ++ show m ++ ":" ++ show s
   |isValid(TimeStamp (h, m, s)) && h < 10 && s < 10                       = "0" ++ show h ++ ":" ++ show m ++ ":" ++ "0" ++ show s
   |isValid(TimeStamp (h, m, s)) && m < 10 && s < 10                       = show h ++ ":" ++ "0" ++ show m ++ ":" ++ "0" ++ show s
   |isValid(TimeStamp (h, m, s)) && h < 10                                 = "0" ++ show h ++ ":" ++ show m ++ ":" ++ show s
   |isValid(TimeStamp (h, m, s)) && m < 10                                 = show h ++ ":" ++ "0" ++ show m ++ ":" ++ show s
   |isValid(TimeStamp (h, m, s)) && s < 10                                 = show h ++ ":" ++ show m ++ ":" ++ "0" ++ show s
   |isValid(TimeStamp (h,m, s)) == False                                   = "Invalid Input"
   |otherwise                                                              = show h ++ ":" ++ show m ++ ":" ++ show s
     
    -- Checking if less then 10 because it's a single digit. 
    -- Adding leading 0 where needed. 
    -- 3 hours, 2 minutes, 5 seconds should look like 03:02:05.
    -- show h converts an int to a String. 

safeFindBefore :: Int -> [Int] -> Maybe [Int] 
safeFindBefore s [] = Nothing  -- Returning nothing. 
safeFindBefore s xs
    |s == last xs       = Just (init xs)   
    |otherwise          = safeFindBefore s (init xs)
-- Just keyword returns what is in the parens. JUST what you tell it to return.
-- safeFindBefore 3 [1,2,4,5,3,6,7]
-- Output: [1,2,4,5]
-- init is everything but the last thing in the list. 
--Example: 3 [1,2,4,3,5] --> 3 [1,2,4,3] --> [1,2,4] 

member :: Int -> Set -> Bool 
data Set = Set [Int]  -- Data constructor is a list of ints. 
    | EmptySet -- Different data constructor created to represent
               -- an empty set. 
  deriving Show
member _ EmptySet = False -- Wildcard is used bc we don't care what the int value is. Nothing is there. 
member _ (Set []) = False -- Pass a set that is an empty set, there is nothing in the set so return false. 
member x (Set (y:ys)) -- Looking for set in the tuple (y:ys)
    |x == y     = True
    |otherwise  = member x (Set ys)

-- How to test in GHCI: member 3 (Set[1,2,3]) or member 3 (EmptySet) 

size :: Set -> Int 
size EmptySet = 0
size (Set []) = 0 -- Base case: Take away 1 until we reach the empty list to exit. 
size (Set (x:xs)) = 1 + size (Set xs) 

{- ###########################
      [1,2,3]
    1 + size [2,3]
    1 + 1 + size [3]
    1 + 1 + 1 + size []
    1 + 1 + 1 + 0
   ########################### -} 

ins :: Int -> Set -> Set
ins x EmptySet = Set([x]) -- Adding x into an empty set. Return set containing x. 
ins x (Set xs) 
    |member x (Set xs)      = Set xs  -- Use member fn from earlier. Return set unmodified. 
    |otherwise              = mergeSet x (Set xs) -- Created a helper fn to merge the element into the new set. 

-- merges a number into a given set.
-- ins 5 (Set [1,2,3])

mergeSet :: Int -> Set -> Set
mergeSet x (Set (y:ys)) = (Set (x:y:ys))
