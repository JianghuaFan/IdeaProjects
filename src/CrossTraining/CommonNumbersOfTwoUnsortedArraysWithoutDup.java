package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CommonNumbersOfTwoUnsortedArraysWithoutDup {
	// Method 1: two pointers:
	public List<Integer> common(int[] a, int[] b) {
		List<Integer> res = new ArrayList<>();
		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0;
		int j = 0;
		while(i < a.length && j < b.length) {
			if(a[i] == b[j]) {
				res.add(a[i]);
				i++;
				j++;
			}else if ( a[i] < b[j] ) {
				i++;
			}else {
				j++;
			}
		}
		return res;
		
	}
	// Method 2: Two sets:
	public List<Integer> commonII(int[] a, int[] b) {
		   // Write your solution here
		if(a.length > b.length){
			return helper(a,b);
		} else{
			return helper(b,a);
		}
	}
	private List<Integer> helper(int[] longer, int[] shorter){
		List<Integer> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for(int i : shorter){
			set.add(i);
		}
		for(int i : longer){
			if(set.contains(i)){
				res.add(i);
			}
		}
		Collections.sort(res);		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {1, 2, 3};
//		int[] B = {3, 1, 4};
		int[] A = {1, 2, 3, 2};
		int[] B = {3, 4, 2, 2, 2};
		CommonNumbersOfTwoUnsortedArraysWithoutDup common = new CommonNumbersOfTwoUnsortedArraysWithoutDup();
		System.out.println(common.common(A, B));
		
	}

}
