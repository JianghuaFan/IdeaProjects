package DP;

import java.util.Arrays;

public class MinimumCutPalindrome {
	public int minimumCut(String str){
		// DP: 
		// base case:
		if(str == null || str.length() == 0){
		    return -1;
		}
		int n = str.length();
		boolean[][] dp = getBoolean(str);
		int[] M = new int[n];		  
		M[0] = 0;// 一个字母不用切割
		 // start from index = 1 （at least two characters） to check different cutting method, find the minimum cut number
		for(int i = 1; i < n; i++){
		  // i: [0,n-1]    j: [0,i]  对于当前i求出所有j即可能切法的最小值赋给M[i]
			int min = Integer.MAX_VALUE;
			if(dp[0][i]) {
				  min = 0;// 如果对于0到i直接是回文，不用切
			}else {//左段查表M[j]，右段[j+1, i]计算
				for(int j = 0; j < i; j++){		      	
//					if(isPalindrome(str,j+1, i)){
					if(dp[j+1][i]) {// 把是否回文的判断记录成dp二维数组，i表示row，j表示col，减少了这一层n的时间复杂度
						min = Math.min(min, M[j] + 1);		        
					}
				}  
				M[i] = min;
			}		    
		}
	
		return M[n-1];
	}	
	
	private boolean[][] getBoolean(String str){
		int n = str.length();
		boolean[][] dp = new boolean[n][n];
		for(int i = n-1; i >= 0; i--) {
			for(int j = i; j < n; j++) {
				if(str.charAt(i) == str.charAt(j)) {
					if(i == j || j == i+1) {
						dp[i][j] = true;
					}else {
						dp[i][j] = dp[i+1][j-1];
					}
				}
			}
		}
		return dp;
	}

	private boolean isPalindrome(String str, int start, int end){
		if(str == null || str.length() == 0 || str.length() == 1){
			return true;
		}	
		while(start <= end){
			if(str.charAt(start) != str.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	public int minCuts(String input) {
		// Write your solution here
		if(input == null || input.length() == 0){
			return Integer.MAX_VALUE;
		}
		int[] minCut = new int[input.length()];
		// base case:
		minCut[0] = 0; // index == 0 meaning only one letter
		boolean[][] dp = new boolean[input.length()][input.length()];
		for(int i = input.length() - 1; i >= 0; i--){
			for(int j = i; j < input.length(); j++){
				if(i == j){
					dp[i][j] = true;
				}else if(j == i + 1){
					dp[i][j] = input.charAt(i) == input.charAt(j);
				}
				else{
					if(input.charAt(i) == input.charAt(j)){
						dp[i][j] = dp[i + 1][j - 1];
					}
				}
			}
		}
		for(int i = 0; i < input.length(); i++){
			minCut[i] = Integer.MAX_VALUE;
			if(dp[0][i]){
				minCut[i] = 0;
			}else{
				for(int j = 0; j < i; j++){
					if(dp[j + 1][i]){
						minCut[i] = Math.min(minCut[i], minCut[j] + 1);
					}
				}
			}
		}
		return minCut[input.length() - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCutPalindrome min = new MinimumCutPalindrome();
		String str = "aabb";
		System.out.println(min.minimumCut(str));
		System.out.println(min.minCuts(str));
	}

}
