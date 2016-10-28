package Strings;

import java.util.Stack;

public class ExpressionCheck {
	public static boolean checkBrackets(String s){
		if(s== null || s.length()==0) return true;
		Stack<Character> stack = new Stack<Character>();
		
		for(char ch : s.toCharArray()){
			if(ch == '{' || ch =='[' || ch =='('){
				stack.push(ch);
				continue;
			}
			if(ch == '}'){
				if(stack.isEmpty() ||stack.peek() != '{') return false;
				stack.pop();
			}
			if(ch == ']'){
				if(stack.isEmpty() || stack.peek() != '[') return false;
				stack.pop();
			}
			if(ch == ')'){
				if(stack.isEmpty() || stack.peek() != '(') return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String args[]){
		System.out.println("result 1:"+ExpressionCheck.checkBrackets("{4-[3/4]}"));
		System.out.println("result 2:"+ExpressionCheck.checkBrackets("4}"));
		System.out.println("result 3:"+ExpressionCheck.checkBrackets("(4-3/4]}"));
	}
	
}
