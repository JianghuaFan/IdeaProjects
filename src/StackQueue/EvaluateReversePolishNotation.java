package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int res = -1;
        for (String s : tokens) {
        	if (s.equals("+")) {
        		stack.push(stack.pop() + stack.pop());
        	} else if (s.equals("-")) {
        		int a = stack.pop();
                int b = stack.pop();
        		stack.push(b - a);
        	} else if (s.equals("*")) {
        		stack.push(stack.pop() * stack.pop());
        	} else if (s.equals("/")) {
        		int a = stack.pop();
                int b = stack.pop();
        		stack.push(b / a);
        	} else {
        		stack.push(Integer.parseInt(s));
        	}
        }
        return stack.pop();
        
//        Stack<Integer> stack = new Stack<Integer>();
//        
//        for (int i = 0; i < a.length; i++) {
//          switch (a[i]) {
//            case "+":
//              stack.push(stack.pop() + stack.pop());
//              break;
//                
//            case "-":
//              stack.push(-stack.pop() + stack.pop());
//              break;
//                
//            case "*":
//              stack.push(stack.pop() * stack.pop());
//              break;
//
//            case "/":
//              int n1 = stack.pop(), n2 = stack.pop();
//              stack.push(n2 / n1);
//              break;
//                
//            default:
//              stack.push(Integer.parseInt(a[i]));
//          }
//        }
//        
//        return stack.pop();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] s = {"2","1","+","3","*"}; 
		String[] s = {"4","13","5","/","+"};
		EvaluateReversePolishNotation polish = new EvaluateReversePolishNotation();
		System.out.print(polish.evalRPN(s));
		
	}

}
