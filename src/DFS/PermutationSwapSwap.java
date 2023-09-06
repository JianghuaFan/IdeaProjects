package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationSwapSwap {
	public List<String> permutations(String input) {
	   	// Write your solution here
	 	List<String> res = new ArrayList<>();
		char[] array = input.toCharArray();
		DFS(array, res, 0);
		return res;
	}
	public void DFS(char[] array, List<String> res, int index){
		if(index == array.length){
			res.add(new String(array));
		}
		Set<Character> elementIHaveFixedAthThisLevel = new HashSet<>();	
		for(int i = index; i < array.length; i++) {
			if(!elementIHaveFixedAthThisLevel.contains(array[i])) {
				elementIHaveFixedAthThisLevel.add(array[i]);
				swap(array, index, i);
				DFS(array, res, index + 1);
				swap(array, index, i);
			}
		}	
	}
	public List<String> permutationWithOutDup(String input){
		List<String> res = new ArrayList<>();
		if(input == null || input.length() == 0){
			return res;
		}
		char[] array = input.toCharArray();
		DFSWithOutDup(res, array, 0);
		return res;
	}

	public void DFSWithOutDup(List<String> res, char[] array, int index){
		if(index == array.length){
			res.add(new String(array));
			return;
		}
		for(int i = index; i < array.length; i++){
			swap(array, index, i);
			DFSWithOutDup(res, array, index + 1);
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
		PermutationSwapSwap permute = new PermutationSwapSwap();
		List<String> res = permute.permutations("abb");
		System.out.println(res);
		System.out.println(permute.permutationWithOutDup("abc"));
		
	}

}
