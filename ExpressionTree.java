import java.util.EmptyStackException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class ExpressionTree {
	  private static Node<String> root;
	  
	  //Constructor
	  public ExpressionTree(String postFix) {
	    growTree(postFix);
	  }
	  
	  //Turns the string input into a stack then into a tree
	  public void growTree(String input){
			
		    String splitArr[] = input.split(" ");
		    //Splitting the input string by spaces, putting each split character in an array.
		    
		    //Making the split strings into nodes, then putting them in a stack.
		    Stack<Node<String>> stack = new Stack<Node<String>>();
		    for(int i=0; i<splitArr.length; i++){
		    	Node<String> temp = new Node(splitArr[i]);
		    	stack.push(temp);
		    }
		    
		    //iterates through the stack. When you see an operator,
		    //make it so that the two numbers before it are the left and right subtrees.
		    for(int i = 0; i < splitArr.length; i++) {

				// if number, just push on to stack as a node with the given value.
				if(splitArr[i].equals("1") || splitArr[i].equals("2") || splitArr[i].equals("3") ||
				  splitArr[i].equals("4") || splitArr[i].equals("5") || splitArr[i].equals("6") ||
				  splitArr[i].equals("7") || splitArr[i].equals("8") || splitArr[i].equals("9")
				  || splitArr[i].equals("0")){
				    stack.push(new Node<String>(splitArr[i]));
				}
				
				//else if operator, first pop = right, second pop = left, push on to stack the operator with 2 number nodes below
				else if(splitArr[i].equals("+") || splitArr[i].equals("-") || splitArr[i].equals("*")
				 || splitArr[i].equals("/")){
					stack.push( new Node<String>(splitArr[i], stack.pop(), stack.pop()) );
					//creates a node with operator and the 2 numbers as right and left leaves under it.
				}
				else{
				  System.out.println("Error: input string contains something other than numbers and operators");
				}
		    }
		    
		    root = stack.pop();
		  }
	
	//Prefix, infix, postfix code from recitation
	//iterates through tree, gets root first, then left, then right.
    public String prefix()
	  {
		  StringBuilder sb = new StringBuilder();
		  prefix(root, sb);
		  return sb.toString().trim();
	  }
	  private void prefix(Node<String> node, StringBuilder sb)
	  {
		  sb.append(node);
		  sb.append(" ");
		  
		  if(node.left != null){
			  prefix(node.left, sb);
		  }
		  if(node.right != null){
			  prefix(node.right, sb);
		  }
	  }
	  
	//iterates through tree, gets left first, then root, then right.
	  public String infix()
	  {
		  StringBuilder sb = new StringBuilder();
		  infix(root, sb);
		  return sb.toString().trim();
	  }
	  
	  private void infix(Node<String> node, StringBuilder sb)
	  {
		  if(node.left != null){
			  infix(node.left, sb);
		  }
		  sb.append(node);
		  sb.append(" ");
		  
		  if(node.right != null){
			  infix(node.right, sb);
		  }
	  }
	  
	 //iterates through tree, gets left first, then right, then root.
	 public String postfix(){
		 StringBuilder sb = new StringBuilder();
		 postfix(root, sb);
		 return sb.toString().trim();
	 }
	 private void postfix(Node<String> node, StringBuilder sb)
	 {
		 if(node.left != null)
		 {
			 postfix(node.left, sb);
		 }
		 
		 if(node.right != null)
		 {
			 postfix(node.right, sb);
		 }
		 sb.append(node);
		 sb.append(" ");
	 }
	public float eval() {
		return eval(root);
	}
	
	
	private float eval(Node<String> node) {
		//if node = number, do nothing, just change it into a number.
		if(node.val.equals("1") || node.val.equals("2") || node.val.equals("3") ||
				node.val.equals("4") || node.val.equals("5") || node.val.equals("6") ||
				node.val.equals("7") || node.val.equals("8") || node.val.equals("9")
				  || node.val.equals("0")){
			
			return Float.parseFloat(node.val);
		}
		//Else if it's an operator, call eval below with 3 arguments: operator, right, left.
		else if(node.val.equals("+") || node.val.equals("-") || node.val.equals("*")
				 || node.val.equals("/")){
	
			return eval(node, eval(node.right), eval(node.left));
		}
		else {
			throw new IllegalArgumentException("Entered invalid argument");
		}
	}
	


//Adds, subtracts, multiplies, divides, depending on the operator.
	private float eval(Node<String> node, float x, float y) {
		if(node.val.equals("+")) {
			return x+y;
		}
		else if(node.val.equals("-")) {
			return x-y;
		}
		else if(node.val.equals("*")) {
			return x*y;
		}
		else if(node.val.equals("/")) {
			return x/y;
		}
		else {
			throw new IllegalArgumentException("Operator Error");
		}
	}
	
	private static class Node<String> {
	    private String val;
	    private Node<String> left;
	    private Node<String> right;
	    
		public Node(String val){
			//constructor with value
			this.val = val;
		    this.right = null;
		    this.left = null;
		}
		
		public Node(String val, Node<String> R, Node<String> L){
			//constructor for when you need to insert node with 2 children
		    this.val = val;
		    this.left = L;
		    this.right = R;
		}
		
		public Node<String> getLeft(){
			return left;
		}
		public Node<String> getRight(){
			return right;
		} 
		public String getVal(){
			return val;
		}
		public java.lang.String toString(){
		      return "" + val.toString();
		}
	}
	
}