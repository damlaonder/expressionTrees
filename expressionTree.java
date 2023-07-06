package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

//import calc.calcLinkedList.Node;

public class expressionTree {
	//set precedence method for operators 
		public static int precedence(char x) {
			//assign precedence based on pemdas 
			if (x=='+' || x=='-') {
				return -3;
			}
			else if (x=='^'){
				return -1;
			}
			else {
				return -2;
			}
		}
		
		//method
		public static String toPostFix(String str) {
		Stack<String> stack = new Stack<String>();
		
		//string variable to hold postfix expression
		String postFix = "";
		
		//parse all characters in expression into an array to keep track 
		LinkedList<String> eqArray = ParserHelper.parse(str.toCharArray());
		//linked list 
		//LinkedList<String> eqLinked = new LinkedList<String>(eqArray);
		//look java function for linked list, parse through, each node will contain a character and 
		
		
		for(String x: eqArray) {
//			System.out.println("|"+x+"|");
			//get all nonoperators  
			if (!x.equals("+") && !x.equals("-") && !x.equals("*") && !x.equals("/") && !x.equals("^") && !x.equals("(") && !x.equals(")")) {
				postFix+= x + " ";
			}
			//get the open parentheses
			else if (x.equals("(")) {
				//push onto the stack 
				stack.push(x);
			}
			//close parenthesis
			else if (x.equals(")")) {
				while (stack.isEmpty() == false) {
					String y = stack.pop();
					if(!y.equals("(")) {
						postFix+=y +" ";
					}
					//leave the loop when you make it to the corresponding open parenthesis 
					else {
						break;
					}
				}
			//go through and check for other operators after parentheses 
			}
			else if ( x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("^")) {
				//if stack is empty/has no parentheses, then just push these operators
				if (stack.isEmpty()) {
				stack.push(x);	
				}
				else {
					while (stack.isEmpty() == false) {
						String y = stack.pop();
						if (y.equals("(")) {
							stack.push(y);
							break;
						}
						else if(y.equals("+") || y.equals("-") || y.equals("*") || y.equals("/") || y.equals("^")) {
							if (precedence(y.charAt(0)) < precedence(x.charAt(0))) {
								stack.push(y);
								break;
							}
							else {
								postFix+=y +" " ;
							}
						}
					}
					stack.push(x);
				}
				}
				
			}
		while (stack.isEmpty() == false) {
			postFix+=stack.pop() +" ";
		}
		//return postFix expression
		//System.out.println(postFix);
		return postFix;
		}
				    
				    
	 
		// make expression tree from postfix expression
		public static Node convert(String postfix){

		//parse all characters in expression into an array to keep track 
		LinkedList<String> eqArray = ParserHelper.parse(postfix.toCharArray());
				    	
		// empty stack - nodes
		//Stack<Node> stack = new Stack<>();
		Stack<Node> stackTree = new Stack<Node>();
        
        
		//System.out.println(eqArray);
		// parse through linked list 
        
		for(String i: eqArray ) {
			if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/") || i.equals("^")){
				Node x = stackTree.pop();
				Node y = stackTree.pop();
				
				Node node = new Node(i, y, x);
				//System.out.println(String.format("node %s",node.toString()));
				stackTree.push(node);
			}
			
			else {
				Node numNode = new Node(i);
				//System.out.println(String.format("node %s",numNode.toString()));
				stackTree.push(numNode);
			}
			
		
			
			
		}
		
		
		return stackTree.peek();
		}
				   
		// post fix
		public static void postorder(Node root) {
			if (root == null) {
			return;
		}
			postorder(root.l);
			postorder(root.r);
			System.out.print(root.data+" ");
		}
				    
		// prefix 
		public static void preorder(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.data+" ");
			preorder(root.l);
			preorder(root.r);
		}
				 
		// infix 
		public static void inorder(Node root){
			if (root == null) {
				return;
			}
				 
			// if the current token is an operator, print open parenthesis
			if (root.data.equals("+") || root.data.equals("-") || root.data.equals("*") || root.data.equals("/") || root.data.equals("^")) {
				  System.out.print("(");
			}
				 
			inorder(root.l);
			System.out.print(root.data+" ");
			inorder(root.r);
				 
			// if the current token is an operator, print close parenthesis
			if (root.data.equals("+") || root.data.equals("-") || root.data.equals("*") || root.data.equals("/") || root.data.equals("^")) {
				System.out.print(")");
			}
		}
				 
				  
				}


	
