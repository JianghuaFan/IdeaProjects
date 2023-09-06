package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsWithDup {
	public List<String> findSubsetsWithDup(String set){
		List<String> subsets = new ArrayList<>();
		if(set == null) {
			return subsets;
		}
		char[] input = set.toCharArray();
		//make sure the set is sorted so that we can dedup
		Arrays.sort(input);
		StringBuilder currentSubsets = new StringBuilder();
		DFS(input, currentSubsets, 0, subsets);
		return subsets;
	}
	
	public void DFS(char[] input, StringBuilder currentSubsets, int index, List<String> subsets) {
		if(index == input.length) {
			subsets.add(currentSubsets.toString());
			return;
		}							
		// index: at current level, determine if the element at "index" should be included in the subset or not
		// case 1: we add the current char in input
		currentSubsets.append(input[index]);
		DFS(input, currentSubsets, index + 1, subsets);
		currentSubsets.deleteCharAt(currentSubsets.length() - 1);			
		
		// skip all consecutive and duplicate elements.
		//通过画图知道，吐了之后回溯到上一步，如果当前index和index+1 的值一样的话，其实父节点已经做过判断了
		while(index + 1 < input.length && input[index] == input[index + 1]) {
			index++;
		}
		// case 2: we do not add the current char in input
		DFS(input, currentSubsets, index + 1, subsets);		
		//对于不转化为char Array的string来说，没有排序字母顺序，所以对于abab会出现重复	

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllSubsetsWithDup find = new AllSubsetsWithDup();		
		String input = "abb";
//		String input = "";
		List<String> res = find.findSubsetsWithDup(input);
		System.out.print(res);
	}
}
