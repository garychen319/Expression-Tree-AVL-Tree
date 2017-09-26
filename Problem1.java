import java.util.EmptyStackException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Problem1{

	public static void main (String[] args) {
		//Command line statements to ask for a filename input
		System.out.print("Please enter a postfix expression:");
		BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		try {
			input = B.readLine();
			ExpressionTree expTree = new ExpressionTree(input);
			
			System.out.print("Eval: ");
			System.out.println(expTree.eval());
			
			System.out.print("Postfix: ");
			System.out.println(expTree.postfix());
			
			System.out.print("Prefix: ");
			System.out.println(expTree.prefix());
			
			System.out.print("Infix: ");
			System.out.println(expTree.infix());	
		}
		
		catch (IOException ex) {
			System.out.println("IO error trying to read postfix expression.");
			System.exit(1);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		catch (EmptyStackException e) {
			System.out.println(e.getMessage());
		}
		
	}
}