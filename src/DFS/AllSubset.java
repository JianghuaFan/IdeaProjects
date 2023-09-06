package DFS;
import java.util.ArrayList;
import java.util.List;
public class AllSubset{

	public List<String> subSets(String set) {
		List<String> res = new ArrayList<>();
		if(set == null) {
			return res;
		}
		StringBuilder sb = new StringBuilder();	
		char[] arraySet = set.toCharArray();
		DFS(arraySet, sb,0, res);
		return res;
	}
	
	public void DFS(char[] arraySet, StringBuilder sb, int index, List<String> res) {
//		
		if(index == arraySet.length) {
			res.add(sb.toString());		
			return;
		}			
		
		//case1 : choose set.charAt(index)
		sb.append(arraySet[index]);
		DFS(arraySet, sb, index + 1, res);
		sb.deleteCharAt(sb.length() - 1);
		while(index + 1 < arraySet.length && arraySet[index] == arraySet[index + 1]){
			index++;
		}

		
		//case 2: not choose set.charAt(index) 
		DFS(arraySet, sb, index + 1, res);		
	}
	public List<Integer> toList(int[] array){
		List<Integer> list = new ArrayList<>();
		for(int i : array) {
			list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllSubset find = new AllSubset();
		
		String input = "abb";
//		String input = "";
		List<String> res = find.subSets(input);
		System.out.println("res:  "  + res);
	}

}
