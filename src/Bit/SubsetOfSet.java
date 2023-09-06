package Bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetOfSet {
	public static void subsetOfSet( char[] A) {

		int N = A.length;
		for( int i = 0; i < (1 << N); i++) {
			List<String> subset = new ArrayList<>();
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					System.out.println(A[j]);;
				}					
			}
		}
	} 	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] A = {'a','b','c'};
		subsetOfSet(A);

	}

}
