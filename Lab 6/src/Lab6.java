import java.util.LinkedList;
import java.util.Scanner;

public class Lab6 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		LinkedList<String> stack = new LinkedList<String>();
		stack.push("a");

		String userIn = "";

		while (!userIn.equals("exit")) {
			System.out.print("Enter an expression (or exit to terminate): ");
			userIn = scanner.nextLine();
			userIn = userIn.toLowerCase();

			if (userIn.charAt(0) == '}' || userIn.charAt(0) == ']' || userIn.charAt(0) == ')') {
				System.out.print("The expression is NOT balanced\n");
				continue;
			}

			if (!userIn.equals("exit")) {
				String checkBalancedExpr = checkBalancedParentesis(userIn, stack);
				System.out.println(checkBalancedExpr);
			} else
				break;
		}
	}

	public static String checkBalancedParentesis(String expr, LinkedList<String> stack) {
		char last = ' ';

		
		 
		

		System.out.print(stack);

		for (int i = 0; i < expr.length(); i++) {

			char current = expr.charAt(i);
			if (current == '{' || current == '(' || current == '[')
				stack.push(String.valueOf(current));

			if (current == '}' || current == ')' || current == ']')
				last = stack.peekFirst().charAt(0);

			if (current == '}' && last == '{')
				stack.pop();
			if (current == ')' && last == '(')
				stack.pop();
			if (current == ']' && last == '[')
				stack.pop();
		}
		// Ternary operator to return the proper string based on the outcome
		return stack.peekFirst().equalsIgnoreCase("a") ? "The expression is balanced" : "The expression is NOT balanced";
	}
}