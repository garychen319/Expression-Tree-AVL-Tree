import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

public class Problem2 {
	AvlTree<String> tree;
	public static int lineCount;

	
	public Problem2() {
		tree = new AvlTree<String>();
		lineCount = 0; //starting at line 0.
	}
	
	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Please Input a Filename:");
			
			//Takes in file name
			BufferedReader B = new BufferedReader(new InputStreamReader(System.in));
			String filename;
			filename = B.readLine();
			
			//Open and scan the file with entered filename
			File file = new File(filename);
			//System.out.println(filename);
			Scanner scan = new Scanner(file);
			Problem2 lineCounter = new Problem2();
			String line;
			while(scan.hasNextLine()) { //goes until the end of the file
				line = scan.nextLine();
				
				//splits the line into individual words and inserts each word
				String[] splitLine = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
				for(String word: splitLine) { 
					lineCounter.insert(word, lineCount);
				}
				lineCount++; //next line number
			}
			lineCounter.print();
			scan.close();
		}
		catch (FileNotFoundException e) { 
			System.out.println("File not found");
		}
		catch (ArrayIndexOutOfBoundsException e) { 
			System.out.println("No arguments have been entered");
		}
	}
	

	void insert(String word, int lineNumber) {
		LinkedList<Integer> list = new LinkedList<>();
		boolean exists = tree.contains(word);
		if(exists == false) { //if word not already in AvlTree
			list.add(lineNumber); //adds line number for the word to the linked list
			tree.insert(word, list); //adds new node to tree
		}
		else {//else word already in tree
			if(!tree.find(word).list.contains(lineNumber)){
				tree.find(word).list.addLast(lineNumber); //just append a number to the linked list of that node
			}
		}
	}

	public void print() {
		tree.printTree(); //Call printTree from AvlTree, which I modified
	}

	
}