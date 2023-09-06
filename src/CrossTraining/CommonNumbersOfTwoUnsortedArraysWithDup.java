package CrossTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonNumbersOfTwoUnsortedArraysWithDup {
	public List<Integer> common(int[] A, int[] B) {
		List<Integer> res = new ArrayList<>();
		Arrays.sort(A);
		Arrays.sort(B);
		int i = 0;
		int j = 0;
		while(i < A.length && j < B.length) {
			if(A[i] == B[j]) {
				res.add(A[i]);
				i++;
				j++;
			}else if ( A[i] < B[j] ) {
				i++;
			}else {
				j++;
			}
		}
		return res;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 2, 3, 2};
		int[] B = {3, 4, 2, 2, 2};
		CommonNumbersOfTwoUnsortedArraysWithDup common = new CommonNumbersOfTwoUnsortedArraysWithDup();
		System.out.println(common.common(A, B));
	}

}
