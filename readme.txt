
Problem1.java is the tester.
ExpressionTree.java is where the functions are located

ExpressionTree.java first has a growTree method that takes in the string input, splits it at white space, and then puts every element in a stack. Then, it takes from the stack and adds each element to the tree. When it sees a number, it will simply push it on the stack. When it sees a operator node, the tree will then pop the next 2 nodes and add them as its right child, then left child, and then push the whole thing on the stack. The program then includes 4 functions, eval postfix, infix and prefix, which evaluates the value of the tree, prints the binary tree in postfix, infix, and prefix order, respectively.

For problem1.java, the tester simply creates an ExpressionTree and calls the 4 functions eval, postfix, infix, prefix. The results are printed out on the command line.


Problem2.java is the tester.
AvlTree is modified to work with Problem2.java
UnderflowException.java was not changed.

For AvlTree.java, I made 4 modifications. First, I added a LinkedList private variable to the AvlNode class. Second, I changed the constructor and the insert method to also take in an additional parameter LinkedList<Integer> ll. Third, I modified printTree so that in addition to printing the value of the node it also prints the linkedList associated with the node. I also added a toString method so the linkedList print would work. Finally, I added a find(AnyType x) function that iterates to through the list and finds the node with the value AnyType x. (I added comments to the parts I added)

Problem 2.java is the tester. In the main it prompts the user for a command line entering of the textfile name, including the .txt extension. It then iterates through the whole file, splits every word on every line by white space, and attempts to insert them all. The insert in problem 2 will create a new node on the AVL tree if the word has never been seen before with a linked list of its line number, else it will find the node that has already been created and add to the linked list private variable of that node the line location it was seen at. The results are printed out on the command line.


To run, simply run Problem1.java and Problem2.java, and you will be prompted to input a string expression and textfile name for the respective problems. Make sure that the text file is in the same folder as Problem2.java.
