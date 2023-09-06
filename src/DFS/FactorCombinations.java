package DFS;

import java.util.ArrayList;
import java.util.List;
/*
 * 404. Factor Combinations
Medium
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
 */
public class FactorCombinations {
	// TC: branch ^ level
	//level: number of factors; 
	//branch: a * a* a ... = n  -> a^k = n  -> k = logn 当a = 2 分组多层数   
	public List<List<Integer>> combinations(int target){
		List<List<Integer>> res = new ArrayList<>();				
		if(target <= 1) {
			return res;
		}
		List<Integer> factors = getFactors(target);
		List<Integer> cur = new ArrayList<>();
		
		// approach 1: 从最大factor开始遍历,方法是每层选几个
		System.out.println("DFSI From biggest factor: how many of current factor to choose");
//		DFSI(res, cur, factors, target, 0);
		helper(res, cur, factors, target, 0);
		System.out.println(res);
		
		// approach 2: 暴力找到从第一个factor到target之间, 每一个可能整除的数（而非factor），方法是每层选哪个数
		System.out.println("DFSII From smallest number equals the first factor:");		
		DFSII(res, cur, factors, target, factors.get(factors.size() - 1));
		System.out.println(res);

		// approach 3:从最大factor开始遍历，方法是每层选哪种factor
		System.out.println("DFSIII From biggest factor: which factor to choose");
		DFSIII(res, cur, factors, target, 0);
		System.out.println(res);
		return res;
	}

//	private List<Integer> getFactors(int target) {
//		List<Integer> factors = new ArrayList<>();
//		for(int i = target/2; i > 1; i--) {
//			if(target % i == 0) {
//				factors.add(i);
//			}
//		}
//		return factors;
//	}
	// 从最大factor开始遍历,方法是每层选几个
	public void DFSI(List<List<Integer>> res, List<Integer> cur, List<Integer> factors, int target, int index){
		if(index == factors.size()) {
			if(target == 1) {
				res.add(new ArrayList<Integer>(cur));
			}			
			return;
		}
		 //case 1: pick 0 不拿当前的factor
		DFSI(res, cur, factors, target, index + 1);
		
		//case 2: 要拿拿几个呢？
		int f = factors.get(index);
		int size = cur.size();

//		int count = 0;// 记录当前层拿了几个f
		while(target % f == 0) {// 剩余的 n 能被当前factor整数的情况下
			cur.add(f);
			target = target / f;// 这里看起来把target改变后到下一层，而且返回后没有吐（恢复到之前target）。但是这里不同个是while loop是
			//同一层之间考虑加几个当前元素,当加一个后肯定要更新target，　再到选再加１个当前的元素。从下一层传入target回来后target是没变的， 因为pass by value
//			count++;
			DFSI(res, cur, factors, target, index + 1);

		}		
		cur.subList(size, cur.size()).clear();
//		for(int i = count; i > 0; i--) {
//			cur.remove(cur.size() - 1);
//		}
//		target = target * f;
	}
	
//	 暴力找到从第一个factor到target之间, 每一个可能整除的数（而非factor），方法是每层选哪个数
	public void DFSII(List<List<Integer>> res, List<Integer> cur, List<Integer> factors, int target, int lastDigit){// lastDigit 从factors里最小的开始选，看选哪个
		if(target == 1) {
			if(cur.size() > 1) {
				res.add(new ArrayList<Integer>(cur));
			}							
			return;
		}
		// 暴力找到从第一个factor（最小的factor 2）到target之间 每一个可能整除的数（而非factor）
		for(int i = lastDigit; i <= target; i++) {
			if(target % i == 0) {
				cur.add(i);
				DFSII(res, cur, factors, target/i, i);
				cur.remove(cur.size() - 1);
			}
		}				
	}
	
	//从最大factor开始遍历，方法是每层选哪种factor, 和DFSI类似，区别是没拿的实现是靠index直接加到后面了
	public void DFSIII(List<List<Integer>> res, List<Integer> cur, List<Integer> factors, int target, int index){
		if(target == 1) {
			if(cur.size() > 1) {
				res.add(new ArrayList<Integer>(cur));
			}							
			return;
		}
		// 每层考虑加哪个factor，用i++, 此种解法收集重复解，从【4,3】，又收集【3，4】
		for(int i = index; i < factors.size(); i++) {
			int f = factors.get(i);
			if(target % f == 0) {
				cur.add(f);
				DFSIII(res, cur, factors, target/f, i);
				cur.remove(cur.size() - 1);
			}
		}				
	}

	public void helper(List<List<Integer>> res, List<Integer> cur, List<Integer> factors, int target, int index){
		System.out.println("helper has been executed:");
		if(target == 1) {
			if(cur.size() > 1) {
				res.add(new ArrayList<Integer>(cur));
			}
			return;
		}
		for(int i = index; i < factors.size(); i++){
			int factor = factors.get(i);
			if(target % factor == 0){
				cur.add(factor);
				helper(res, cur, factors, target/ factor , index + 1);
				cur.remove(cur.size() - 1);
			}
		}
	}
	// highlevel: DFS, find all the combinations of the factors of num like 12
	// assumption: numb is > 2
	// input: an integer
	// output: a list of list of integers
	// step1: calculate all the factors
	// step2: draw a DFS tree , use DFS find all the combinations
	// TC: branch^level : branch: how many factors we choose(at most would be logn), level: the number of factors
	// SC: the number of factors

	public List<List<Integer>> factors(int num){
		List<List<Integer>> res = new ArrayList<>();
		if(num <= 2){
			return res;
		}
		// step1: calculate all the factors
		List<Integer> factors = getFactors(num);
		List<Integer> cur = new ArrayList<>();
		// step2: DFS
		DFS(num, res, cur, 0, factors);
		return res;
	}
	private void DFS(int num, List<List<Integer>> res, List<Integer> cur, int index, List<Integer> factors){
		if(index == factors.size()){
			if(num == 1){
				res.add(new ArrayList<Integer>(cur));
			}
			return;
		}
		// case1: not adding current factor
		DFS(num, res, cur, index + 1, factors);

		// case2: adding current factor, consider how many factors to choose
		int count = 0;
		int factor = factors.get(index);
		while(num % factor == 0){
			cur.add(factor);
			num = num / factor;
			count++;
			DFS(num, res, cur, index + 1, factors);
		}
		for(int i = 0; i < count; i++){
			cur.remove(cur.size() - 1);
		}
	}
	private List<Integer> getFactors(int num) {
		List<Integer> factors = new ArrayList<>();
		for(int i = num / 2; i > 1; i--){
			if(num % i == 0){
				factors.add(i);
			}
		}
		return factors;
	}

	public static void main(String[] args) {
		FactorCombinations factorCombinations = new FactorCombinations();

//		System.out.println(factorCombinations.factors(12));
		System.out.println(factorCombinations.getFactors(12));
		System.out.println(factorCombinations.combinations(12));
	}
}
