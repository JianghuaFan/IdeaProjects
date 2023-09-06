package Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public List<List<Integer>> nQueens(int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		if(n == 0){
			return res;
		}
		helper(n,res,cur);
		return res;
	}
	// res: the result we want
	// cur: the cur for one way, row is index, cur.get(index) is column
	// n: the number of the queens
	public void helper(int n, List<List<Integer>> res, List<Integer> cur ){
		if(cur.size() == n){
			res.add(new ArrayList<>(cur));
			return;
		}
		for(int i = 0; i < n; i++){
			if(isValid(cur, i)){
				cur.add(i);
				helper(n,res,cur);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public boolean isValid(List<Integer> cur, int column){
		int row = cur.size();
		for(int i = 0; i < row; i++){
			if(cur.get(i) == column || Math.abs(column - cur.get(i)) == row - i){
				return false;
			}
		}
		return true;
	}

	public List<List<Integer>> NQueens(int n){
		List<List<Integer>> res = new ArrayList<>();
		if(n == 0) return res;
		List<Integer> cur = new ArrayList<>();
		DFS(res, cur,  n);
		return res;
	}
	private void DFS(List<List<Integer>> res, List<Integer> cur, int n){
		if( cur.size() == n){
			res.add(new ArrayList<>(cur));
		}
		for(int col = 0; col < n; col++){
			if(valid(cur, col)){
				cur.add(col);
				DFS(res, cur, n);
				cur.remove(cur.size() - 1 );
			}
		}
	}
	private boolean valid(List<Integer> cur, int col){
		for(int i = 0; i < cur.size(); i++){
			if(col == cur.get(i) || Math.abs(cur.size() - i) == Math.abs( col - cur.get(i))){
				return false;
			}
		}
		return true;
	}

	public List<List<Integer>>  NQueensP(int n){
		// high level: every time put one queen in a row, then go to next row, use DFS + backtracking
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		helperP(res, cur, n);
		return res;
	}
	public void helperP(List<List<Integer>> res, List<Integer> cur, int n){
		// base case: we have finished all the rows
		if(cur.size() == n){
			res.add(new ArrayList<>(cur));
			return;
		}
		int row = cur.size();
		for(int col = 0; col < n; col++){
			// recursion rule: if current row is valid, then go to next row
			if(isValidP(cur, col)){
				cur.add(col);
				helperP(res, cur, n);
				cur.remove(cur.size() - 1);
			}
		}
	}
	public boolean isValidP(List<Integer> cur, int col){
		// check whether the col is conflict with all the col numbers in the cur list, which includes all the cols have been used
		int row = cur.size();
		for(int i = 0; i < row; i++){
			if(col == cur.get(i)){
				return false;
			}
			if ((row - i) == Math.abs(col - cur.get(i))){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens nQueens = new NQueens();
		int n = 4;
		System.out.println(nQueens.NQueensP(n));
		System.out.println(nQueens.nQueens(n));		
	}

}
