package proplem_3;

import java.util.ArrayList;
import java.util.Stack;

/*Create a program which checks if the string has the correct order of
 *  parenthesis/brackets. 
 *  ({})[] = true, []{]}[ = false
 *  */

public class ParanthesisChecker {

	public static void main(String args[]) {

		System.out.println(checkBalancedParanthesis("({})[]((({{{}}})))"));
		System.out.println(checkBalancedParanthesis("[[[]]])("));
	}

	public static boolean checkBalancedParanthesis(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '(' || c == '{') {
				stack.push(c);
			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			} else if (c == ')') {
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			} else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}
}
