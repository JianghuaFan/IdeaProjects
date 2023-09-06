package DFS;

import java.util.ArrayList;
import java.util.List;
/*
 * 66. All Valid Permutations Of Parentheses I
Medium
Given N pairs of parentheses “()”, return a list with all the valid permutations.

Assumptions

N > 0
Examples

N = 1, all valid permutations are ["()"]
N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 */
public class AllValidParentheseI {
	public List<String> validParenthese(int n){
		List<String>  res = new ArrayList<>();
		if(n <= 0) {
			return res;
		}
		StringBuilder sb = new StringBuilder();
		DFS(res, sb, 0, 0, n);
		return res;
	}
	public void DFS(List<String>  res, StringBuilder sb, int left, int right, int n) {
		if(left == n && right == n) {
			res.add(sb.toString());
			return;
		}
		if(left < n) {
			sb.append('(');
			DFS(res, sb, left + 1, right, n);
			sb.deleteCharAt(sb.length() - 1);
		}
		if(right < left) {
			sb.append(')');
			DFS(res, sb, left, right + 1, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllValidParentheseI valid = new AllValidParentheseI();
		System.out.println(valid.validParenthese(2));
	}

}
