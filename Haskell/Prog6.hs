{- ###########################
	Phillip Squarcetta
	4/23/2020
	Homework 6
   ########################### -} 

module Prog6 where


data Set = Set [Int]         
         | EmptySet  
    deriving Show

equal :: Set -> Set -> Bool
equal (Set xs) (Set ys) 
  |xs == ys           = True
  |otherwise         = False
  
saferemove :: Int -> Set -> Maybe Set 
saferemove _ EmptySet = Nothing
saferemove _ (Set []) = Nothing
saferemove n (Set ys)
    | elem n ys == False = Nothing 
    | otherwise = Just(Set([x | x <- ys, x /= n])) 

union :: Set -> Set -> Set 
union (Set xs) (Set ys) = (Set(xs++[y|y<-ys, member y (Set xs)==False])) 
-- Keep around if the y is not in xs.  
-- Also eliminates duplicate number (Set [1,2,3]) (Set [3,4,5])

member :: Int -> Set -> Bool 
member _ EmptySet = False -- Wildcard is used bc we don't care what the int value is. Nothing is there. 
member _ (Set []) = False -- Pass a set that is an empty set, there is nothing in the set so return false. 
member x (Set (y:ys)) -- Looking for set in the tuple (y:ys)
  |x == y     = True
  |otherwise  = member x (Set ys) 

data Tree = Leaf Int         
          | Node Tree Int Tree

preorder (Leaf a) = [a]
preorder (Node left x right) = [x] ++ preorder left ++ preorder right

postorder :: Tree -> [Int]
postorder (Leaf a) = [a]
postorder (Node left x right) = postorder left ++ postorder right ++ [x]

countZeros :: Tree -> Int
countZeros xs = length[x | x <- (preorder xs), x == 0]

countLeaves :: Tree -> Int
countLeaves (Leaf a) = 1
countLeaves (Node left x right) = countLeaves left + countLeaves right

countInteriorNodes :: Tree -> Int
countInteriorNodes (Leaf x) = 0
countInteriorNodes (Node left x right) = 1 + (countInteriorNodes left) + (countInteriorNodes right)

depth :: Tree -> Int
depth (Leaf a) = 0
depth (Node left x right) = 1 + (max (depth left)  (depth right))

balanced :: Tree -> Bool 
balanced (Leaf x) = True
balanced (Node left x right) = (bal <= 1) && (bal >= (-1))
   where bal = (countNodes left) - (countNodes right)

countNodes :: Tree -> Int
countNodes (Leaf x) = 1
countNodes (Node left x right) = countNodes left + countNodes right

