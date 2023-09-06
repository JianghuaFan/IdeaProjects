package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
241. Different Ways to Add Parentheses (Medium)

Leetcode / 力扣

Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2

Output : [0, 2]

recursion tree
                                    2 - 1 + 1
level: one operation             /             \
branch: which operator          -               +
                            2     1 + 1     2-1     1
level 2                             +       -
                             2      /\      /\       1
                             2      1 1     2 1      1

 */
public class DifferentWaysToAddParentheses {
    public List<Integer> differentWaysToAddParenthesis(String input){
        // DFS:
        // each level: do one operation, branch: which operator

        return recursion(input);
    }

    private List<Integer> recursion(String input) {
        List<Integer> cur = new ArrayList<>();
//        if(input.length() == 1){
//            cur.add(Integer.valueOf(input));
//            return cur;
//        }
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftParts = recursion(input.substring(0, i));
                List<Integer> rightParts = recursion(input.substring(i + 1));
                for (int left : leftParts) {
                    for (int right : rightParts) {
                        switch (ch) {
                            case '+':
                                cur.add(left + right);
                                break;
                            case '-':
                                cur.add(left - right);
                                break;
                            case '*':
                                cur.add(left * right);
                                break;
                        }
                    }
                }
            }
        }
        if(cur.size() == 0){
            cur.add(Integer.valueOf(input));
        }
//        map.compute(input, (k,v) -> cur);
        return cur;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        String input = "2-1+1";
        System.out.println(differentWaysToAddParentheses.differentWaysToAddParenthesis(input));
    }

}
