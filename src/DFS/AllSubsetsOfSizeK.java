package DFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfSizeK {
	public List<String> subSetsOfSizeK(String set, int k) {
		List<String> res = new ArrayList<>();
		if(set == null){
			return res;
		}
		if(k == 0){
			res.add(new String());
			return res;
		}
		if(k > set.length()){
			return res;
		}
		StringBuilder sb = new StringBuilder();
		DFS(res, set, k, sb, 0);
		return res;
	}
	
	public void DFS(List<String> res, String set, int k, StringBuilder sb, int index){
		
		if(sb.length() == k){
			res.add(sb.toString());
			return;
		}
		if(index == set.length()){
			return;
		}
		// case1 : add the current character at index
		sb.append(set.charAt(index));
		DFS(res, set, k, sb, index + 1);
		sb.deleteCharAt(sb.length() - 1);
		//case 2: not add current character at index
		DFS(res, set, k, sb, index + 1);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AllSubsetsOfSizeK subSetsOfSizeK = new AllSubsetsOfSizeK();		
		String input = "abc";
		List<String> res = subSetsOfSizeK.subSetsOfSizeK(input,2);
		System.out.print(res);
	}

}
