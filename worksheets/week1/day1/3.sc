
val xs = List(1, 2, 3)

0 :: xs

xs.head
xs.tail

xs.tail.head
xs.tail.tail

xs.tail.tail.head
xs.tail.tail.tail

xs.tail.tail.tail

Nil: Nil.type
Nil: List[Nothing]


Nil
3 :: Nil
2 :: (3 :: Nil)
1 :: (2 :: 3 :: Nil)
0 :: (1 :: 2 :: 3 :: Nil)