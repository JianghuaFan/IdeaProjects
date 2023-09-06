package AmazonOA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
1.Code Ouestion 1
Amazon Games has recently launched a bracketmatching pair game for kids. In this game, abracket sequence in the form of a string, s of lengthn is given. The string only contains the characters !!and
In one move, choose two characters, at positions /and isuch that 0 s i <  < n and sli] = '' and sli] =')' and (i - i) points are added to the score. if someindex x is chosen before, it can not be chosenagain.
Determine the maximum possible score
 */
public class GetMaximumScore {

    public static long getMaximumscore(String s){
        // highlevel: traverse the string, count all the sum of '(' and ')', we want to retain the most-left '(' and most right ')', so try to remove the rightmost'(' and mostleft ')'
        // step 1: count all the '(' and the sum, as well as the ')'
        int left = 0;
        int right = 0;
        int leftSum = 0;
        int rightSum = 0;
        int maxScore = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                left++;
                leftSum += i;
            }else{
                right++;
                rightSum += i;
            }
        }
        maxScore = rightSum - leftSum;
        int diff = left - right;
        // step 2: traverse the string again, remove the most right '(' and most-left ')'
        if(diff > 0){
            int i = s.length() - 1;
            while(diff > 0 && i >= 0){
                char c = s.charAt(i);
                if(c == '('){
                    leftSum -= i;
                }
                i--;
                diff--;
            }
        }else if(diff < 0){
            int i = 0;
            while(diff > 0 && i >= 0){
                char c = s.charAt(i);
                if(c == ')'){
                    rightSum -= i;
                }
                diff--;
                i++;
            }
        }else{
            int i = 0;
            int j = s.length() - 1;
            while(i <= j){
                char a = s.charAt(i);
                char b = s.charAt(j);
                if(a == ')'){
                    rightSum -= i;
                }
                i++;
                if(b == '('){
                    leftSum -= j;
                }
                j--;
                maxScore = Math.max(maxScore, rightSum - leftSum);
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        String s1 = "()()";
        long result1 = getMaximumscore(s1);
        System.out.println("Maximum Possible Score for " + s1 + ": " + result1);  // Output: Maximum Possible Score for ()(): 3

        String s2 = "(()())";
        long result2 = getMaximumscore(s2);
        System.out.println("Maximum Possible Score for " + s2 + ": " + result2);  // Output: Maximum Possible Score for (()()): 8

        String s3 = "(()()())";
        long result3 = getMaximumscore(s3);
        System.out.println("Maximum Possible Score for " + s3 + ": " + result3);  // Output: Maximum Possible Score for (()()()): 13

        String s4 = "()()()";
        long result4 = getMaximumscore(s4);
        System.out.println("Maximum Possible Score for " + s4 + ": " + result4);  // Output: Maximum Possible Score for ()()(): 6

        String s5 = "(())";
        long result5 = getMaximumscore(s5);
        System.out.println("Maximum Possible Score for " + s5 + ": " + result5);  // Output: Maximum Possible Score for (()): 4
    }
}
