package DFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
 * 179. All Valid Permutations Of Parentheses II
Hard
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
l + m + n > 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
 */
public class AllValidPermutationsOfParentheseII {
	private static final char[] p = {'(',')','<','>','{','}'};
	// 
	public List<String> validParenthesesIII(int l, int m, int n) {	
	   // Write your solution here
	 	List<String> res = new ArrayList<>();			
		int[] count = {l,l,m,m,n,n};
		int total = 0;
		for(int i : count) {
			total += i;
		}			
		Deque<Character> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		DFS(res, stack, sb, count, total);
		return res;
	 }
	// 没有优先级的DFS
	public void DFS(List<String> res, Deque<Character> stack, StringBuilder sb, int[] count, int total) {
		if(sb.length() == total) {
			res.add(sb.toString());
			return;// 可以不写，因为下面的for loop限制了执行范围
		}
		for(int i = 0; i < count.length; i++) {
			if(i %2 == 0){// meaning left parentheses ,左括号
				if(count[i] > 0){
					//还有左括号
					sb.append(p[i]);
					stack.offerFirst(p[i]);
					count[i]--;
					DFS(res, stack, sb, count, total);
					sb.deleteCharAt(sb.length() - 1);
					stack.pollFirst();
					count[i]++;
				}
			}else {// 右括号
				if(!stack.isEmpty() && stack.peekFirst() == p[i -1]) {
					// stack 不为空， && stack中最后的是相应的待匹配的左括号
					sb.append(p[i]);
					count[i]--;
					stack.pollFirst();
					DFS(res, stack, sb, count, total);
					sb.deleteCharAt(sb.length() - 1);
					count[i]++;
					stack.offerFirst(p[i -1]);	//刚刚弹栈的是相应的左括号				
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllValidPermutationsOfParentheseII validPermutationsOfParenthese = new AllValidPermutationsOfParentheseII();
		;
		System.out.println(validPermutationsOfParenthese.validParenthesesIII(1, 1, 0));
	}

}
