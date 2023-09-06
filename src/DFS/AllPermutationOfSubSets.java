package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfSubSets {
	
	 public List<String> allPermutationsOfSubsets(String set) {
	   // Write your solution here
		List<String> res = new ArrayList<>();
		if(set == null || set.length() == 0){
			return res;
		} 
		StringBuilder sb = new StringBuilder();
		char[] array = set.toCharArray();
		DFS(res, array, sb, 0);
		return res;
	}
	 
	// choose the character to be at the position of "index",
	  //  all the already chosen positions are (0,. index - 1)
	  //  all the candidate characters can be at position "index"
	  //  are the subarray of [index,array.length - 1]
		public void DFS(List<String> res, char[] array, StringBuilder sb, int index){
	    // every state in the recursion tree is a valid result
		res.add(new String(array,0,index));//
		if(index == array.length){
			return;
		}
		for(int i = index; i < array.length; i++){
			swap(array, index, i);
			DFS(res, array, sb, index + 1);
			swap(array, index, i);
		}	
	}
	public void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllPermutationOfSubSets allPermutationOfSubSets = new AllPermutationOfSubSets();
		String set = "abc";
		char[] array = set.toCharArray();
//		System.out.print(new String(array,0,3));
		System.out.print(allPermutationOfSubSets.allPermutationsOfSubsets(set));
	}

}
