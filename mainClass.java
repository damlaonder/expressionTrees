package trees;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get user to enter infix expression:
		Scanner user = new Scanner(System.in);  
		System.out.print("type your infix expresson:");  
		//user input -> save as instance variable called equation 
		String equation= user.nextLine();  
		String postfix = expressionTree.toPostFix(equation);
		System.out.println();
		
		//prefix
		System.out.print("Prefix: ");
		Node prefix = expressionTree.convert(postfix);
		expressionTree.preorder(prefix);
		System.out.println();
		
		
		
		//infix
		System.out.print("Infix: ");
		Node infix = expressionTree.convert(postfix);
		expressionTree.inorder(infix);
		System.out.println();
		
		//postfix 
		System.out.print("Postfix: ");
		Node postfix2 = expressionTree.convert(postfix);
		expressionTree.postorder(postfix2);
		System.out.println();

	}

}
