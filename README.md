# MKS22X
Repository for the Spring 2018 Term of Mr. K's APCS class.

## Aim of the Class:
Most of the content on the AP exam was covered sufficiently by semester 1 of this amazing course. Semester 2 focuses on cooler and harder stuff. For example, we wrote a bunch of maze solvers, basic data structures like Heap and Deque, and just about every relevant sort on this planet. Guess that's why the course is called Data Structures and Algorithms.

## Student
Meredith Hu

## School
Stuyvesant High School

## Table of Contents/What's Done
 - [x] 01Recursion
 - [x] 02NQueens
 - [x] 03Knight
 - [x] 04Maze
 - [x] 05USACO
 - [x] 06Quick
 - [x] 07Merge
 - [x] 08Node
 - [ ] 09StackCalculator
 - [ ] 10Deque
 - [ ] 11ExpressionTree
 - [ ] 12Heap
 - [ ] 13Medians
 - [ ] 14Frontier
 - [x] gitignore
### 01Recursion
A lab dipping our toes into the water regarding recursion; contains a linear factorial function and a square root calculator.

### 02NQueens
Solving the famous NQueens problem -how many different ways can N chess queens be placed on an NxN chess board without them challenging each other?- using recursive backtracking.
 - [ ] still need to optimize, because calculating whether the queens threaten each other is way too long in my code.

### 03Knight
Solving the Knight's Tour (open version) problem -finding the number of ways a knight can make one continuous trip on the chess board that traverses all the squares, and each one only once, but not necessarily ending where it began- using recursive backtracking.

### 04Maze
A depth-first-search maze solver that solves mazes in a specific format (has one S, one E, and is surrounded completely by walls marked by '#' hashmarks) using recursive backtracking.

### 05USACO
Two old USACO problems, both cow themed - bronze is a problem called Lake Making that should really be called "how to parse and read data" and silver is almost a rehash of maze, using recursive backtracking. Yes, we really did do this much recursive backtracking in this class.

### 06Quick
Wrote the single pivot quicksort. Later version also implements dutch-flag partitioning for greater efficiency in sorting arrays with duplicates, and insertion sort because it is faster than quicksort when the array size that is being sorted is less than 10.
 - [ ] still need to optimize this sort or find out what's wrong with it, because it's two orders of magnitude above how it's supposed to be performing

### 07Merge
A mergesorting algorithm that does it in place. Was pretty hell to write.

### 08Node
badly named dir for a self-made linkedlist.
Also hidden in this folder is a beautiful radixsort!

### 09StackCalculator
I think this is a stack based calculator?? 
/lol self explanatory/
 - [ ] still need to DO this one

### 10Deque
wrote a deque. first experimentation with FIFO data structures.
- [ ] still need to do this one too ;-;

### 11ExpressionTree
blast from the past. hey DrRacket I sure didn't miss you, but I can make java evaluate your polish notation now.
- [ ] have to do this

### 12Heap
wrote a heap. Also a heapsort.
Can you tell I'm getting tired writing these descriptions so they're getting progressively shorter and shorter

### 13Medians
Goddamn it did we really code this much in this goddamn class. Solves the Running Medians problem, which finds the median of an array really quickly by turning both sides of it into heaps and comparing the root values.
 - [ ] JUST DO IT

### 14Frontier
Stack-based frontier that keeps track of "places in maze you still need to visit" solves the maze for you. We do it
 - [ ] DFS
 - [ ] BFS
 - [ ] A-star
 - [ ] something else???

