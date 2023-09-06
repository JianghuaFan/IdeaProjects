package DFS;

import java.util.ArrayList;
import java.util.List;
/*
 * 73. Combinations Of Coins
Medium
Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

Arguments

coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
target - a non-negative integer representing the target number of cents, eg. 99
Assumptions

coins is not null and is not empty, all the numbers in coins are positive
target >= 0
You have infinite number of coins for each of the denominations, you can pick any number of the coins.
Return

a list of ways of combinations of coins to sum up to be target.
 */
public class CombinationOfCoins {
	public List<List<Integer>> combinations(int target, int[] coins) {
	    // Write your solution here
	    List<List<Integer>> res = new ArrayList<>();
	    //cur: each combination of coins is represented as a List<Integer>cur, 
	    //all the combinations are stored in the result as List of List<Integer> 
			List<Integer> cur = new ArrayList<>();
			DFS(target, coins, cur , 0, res);
			return res;
		}
		 //target: remaining money we need to complete
	   //coins: all the possible different coins
	   // index: we want to see how many coins we need for coins[index]
		public void DFS(int target, int[] coins, List<Integer> cur , int index, List<List<Integer>> res){
			//temination condition: when we have finished considering all the coins, 
	    if(index == coins.length){
	      // if we have complete collect all the target, we can add ArrayList(cur) to res.
			  if(target == 0){
				  res.add(new ArrayList<>(cur));				
			  }
			  return;
		  }
			// for coins[index], we can pick 0,1, 2, ..., target/coins[index] coins.
//			for(int howManyThiscoinDidUTake = 0; howManyThiscoinDidUTake <= target / coins[index]; howManyThiscoinDidUTake++){
//				cur.add(howManyThiscoinDidUTake);
//	      // remember to modify the remaining cents for the next level
//				DFS(target - howManyThiscoinDidUTake * coins[index] , coins, cur, index + 1, res);
//				cur.remove(cur.size() - 1); 
//			}
			for(int howManyOfThisKindCoin = 0; howManyOfThisKindCoin <= target / coins[index]; howManyOfThisKindCoin++){
//			      target = target - howManyOfThisKindCoin * coins[index];
			      cur.add(howManyOfThisKindCoin);
			      DFS(target - howManyOfThisKindCoin * coins[index], coins, cur, index + 1, res);
			      cur.remove(cur.size() - 1); 
//			      target = target + howManyOfThisKindCoin * coins[index];
//			如果想改变target也一定要吃吐守恒，DFS中不同层之间任何改变都要吃吐守恒。  
			}

	    
		}
	// TC: branch: target, level: n ~ O(target^n) 99^4
	// SC: O(n) where n is the number of coins 4

		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationOfCoins combination = new CombinationOfCoins();
		int target = 99;
		int[] coins = {25,10,5,1};
		List<List<Integer>> res = combination.combinations(target, coins);
		System.out.print(res);

	}

}
