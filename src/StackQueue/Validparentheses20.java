package StackQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Validparentheses20 {
	public static boolean isValidparentheses(String s) {
	Stack<Character> brackets = new Stack<>();
    Map <Character, Character> b = new HashMap<>();
    
    for(char c : s.toCharArray()){
    	if(c == '{' || c == '(' || c == '[')
        brackets.push(c);
    	else {
    		if(brackets.isEmpty()) {
    		return false;
    		}
    		char cBrackets = brackets.pop();
    		boolean b1 = c == ')' && cBrackets != '(';
    		boolean b2 = c == '}' && cBrackets != '{';
    		boolean b3 = c == ']' && cBrackets != '[';
    		if(b1 || b2 || b3) {
    			return false;
    		}
    	}    
    }
    return brackets.isEmpty();
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
