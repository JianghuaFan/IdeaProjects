package BFSHeap;
import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public List<String> permute(String str){
		List<String> res = new ArrayList<String>();
		if(str == null) {
			return res;
		}
		char[] input = str.toCharArray();
		DFS(input, 0, res);
		return res;
	}
	public void DFS(char[] input, int index, List<String> res) {
		if(index == input.length) {
			res.add(new String(input));
		}
		for(int i = index; i < input.length; i++) {
			swap(input, i, index);
			DFS(input, index + 1, res);
			swap(input, i, index);
		}
	}
	public void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation permute = new Permutation();
		List<String> res = permute.permute("abc");
		System.out.print(res);
	}

}
