package CrossTraining;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 * 188. 4 Sum
Medium
Determine if there exists a set of four elements in a given array that sum to the given target number.

Assumptions

The given array is not null and has length of at least 4
Examples

A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)

A = {1, 2, 2, 3, 4}, target = 12, return false

 
 */
public class FourSum {
	// Method 1: divide into 2 sum, sort the array first, TC: O(n^3)
	public boolean existI(int[] array, int target) {
		   // Write your solution here
		int n = array.length;
		Arrays.sort(array);
		for(int i = 0; i <  n - 3; i++){
			for(int j = i + 1; j < n - 2; j++){
				int left = j + 1;
				int right = n - 1;
				int curTarget = target - array[i] - array[j];
				while(left < right){
					int sum = array[left] + array[right];
					if( sum == curTarget){
						return true;
					}else if(sum < curTarget){
						left++;
					}else{
						right--;
					}
				}
			}
		}
		return false;
	}
	// Method 2: use map, traverse one loop  TC: O(n^2)
	public boolean existII(int[] array, int target) {
		   // Write your solution here
		Map<Integer, Pair> map = new HashMap<>();
		for(int i = 1; i < array.length; i++){//当前对儿： j在左，i在右
			for(int j = 0; j < i; j++){
//		for(int j = 0; j < array.length; j++){//当前对儿： j在左，i在右.这种定义i 和j的办法不行。还是需要把j定义成<i
//			for(int i = j+1; i < array.length; i++){	
				int pairSum = array[i] + array[j];
				// 找到map里已有的和pairSum能配对的另一对数，且要求另一对数的右边的数是在当前pair对儿的左边
				if(map.containsKey(target - pairSum) && map.get(target - pairSum).right < j){
					return true;
				}
				if(!map.containsKey(pairSum)){
					map.put(pairSum, new Pair(j,i));
				}
			}
		}
		return false;
	}
	// Method 3: use map, traverse two loop  TC: O(n^2) 
	// 关系是 j1 ---- j1 ---- i2 ----  j2
	public boolean existIII(int[] array, int target) {
		   // Write your solution here
		Map<Integer, Pair> map = new HashMap<>();
		for(int j1 = 1; j1 < array.length; j1++){//当前对儿： j1在左，j1在右
			for(int i1 = 0; i1 < j1; i1++){
				int pairSum = array[i1] + array[j1];
				// 找到map里已有的和pairSum能配对的另一对数，且要求另一对数的右边的数是在当前pair对儿的左边
				if(!map.containsKey(pairSum)){
					map.put(pairSum, new Pair(i1,j1));
				} 
			}
		}
		for(int i2 = 0; i2 < array.length; i2++){//当前对儿： j2在左，i2在右
			for(int j2 = i2+ 1; j2 < array.length; j2++){
				int pairSum = array[i2] + array[j2];
				// 找到map里已有的和pairSum能配对的另一对数，且要求另一对数的右边的数是在当前pair对儿的左边(即右边数的index小于当前左边index)
				if(map.containsKey(target - pairSum) && map.get(target - pairSum).right < i2){
					return true;
				} 							
			}
		}
		return false;
	}
		
	class Pair{
		int left; 
		int right;
		public Pair(int left, int right){
			this.left = left;
			this.right = right;
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum fourSum = new FourSum();
		int[] array = {1, 2, 2, 3, 4};
		int[] array1 = {2,1,1,1,0};
		int target = 3;
//		System.out.println(fourSum.existI(array1, target));
		System.out.println(fourSum.existII(array1, target));
		System.out.println(fourSum.existIII(array1, target));
	}

}
