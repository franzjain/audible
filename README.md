Introduction=====================================================================================
  This project contains the solution to Audible code test

Requirement======================================================================================

  Given a “n x m” array (n & m could be different or same numbers), print the contents of the array in a spiral order (i.e. print the outermost elements followed by the next inner layer followed by the next inner layer and so on until all elements are printed) in a clockwise manner. Note that all elements of the array should be printed only once.
The input could be either read from a text file or from a command prompt and the output should be printed on a console.
 
Example 1:
 
Array contents:
A b c d e 1 
F g h i j 2
K l m n o 3
P q r s t 4
 
Output: a b c d e 1 2 3 4 t s r q p k f g h i j o n m l
 
Example 2:
 
Array contents:
1   2   3   4
5   6   7   8
9 10 11 12
Output: 1 2 3 4 8 12 11 10 9 5 6 7

How to run the program===========================================================================

  1. With file input
    Save input in text file with name specified.
  	After compiled java code, run "java audible.ArrayPrinter file.name".
  	
  2. With Console input
  	After compiled java code, run "java audible.ArrayPrinter", and then input each line in the console.
  	Press "enter" key twice signals the end of input.