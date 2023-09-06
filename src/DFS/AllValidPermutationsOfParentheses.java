package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParentheses {
	public List<String> validParentheses(int n){
		List<String> res = new ArrayList<>();
		if(n == 0) {
			return res;
	}
		int left = 0;
		int right = 0;
		StringBuilder sb = new StringBuilder();
		helper(n, left, right, sb, res);
		return res;
	}

	public void helper(int n, int left, int right, StringBuilder sb, List<String> res){
		if(left == n && right == n){
			res.add(sb.toString());
			return;
		}
		//case 1: add “(”
		if(left < n){
			sb.append("(");
			helper(n, left + 1, right, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
		if(right < left){
			sb.append(")");
			helper(n, left, right + 1, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllValidPermutationsOfParentheses validParentheses = new AllValidPermutationsOfParentheses();
		int n = 2;
		List<String> res = validParentheses.validParentheses(n);
		System.out.print(res);
	}

}
