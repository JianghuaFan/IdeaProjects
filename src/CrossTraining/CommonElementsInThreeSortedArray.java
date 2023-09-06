package CrossTraining;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInThreeSortedArray {
	public List<Integer> common(int[] a, int[] b, int[] c) {
		   // Write your solution here
		// TC: O(max(a,b,c)  SC: O(1)
		List<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		int k = 0;
		while( i < a.length && j < b.length && k < c.length){
			if(a[i] == b[j] && b[j]== c[k]){
				res.add(a[i]);
				i++; j++; k++;				
			}else{
				int min = Math.min(a[i], Math.min(b[j], c[k]));
				if(min == a[i]){ 
					i++;
				}
				else if(min == b[j]){ 
					j++;
				}
				else{ 
					k++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,3,4,4,7};
		int[] b = {1,1,3,3,4,4,4};
		int[] c = {1,1,1,3,4,4,5};
		CommonElementsInThreeSortedArray common = new CommonElementsInThreeSortedArray();
		System.out.print(common.common(a, b, c));
	}

}
