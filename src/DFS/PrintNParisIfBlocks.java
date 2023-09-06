package DFS;
import java.util.List;
import java.util.ArrayList;

public class PrintNParisIfBlocks {	
	public static final char[] input = {'{', '}'};
	public void printNParisIfBlocks(int n){
	  if(n <= 0){
	    return;
	  }	
	  List<Character> res = new ArrayList<>();
	  DFS(n, n, res);
	}
	
	public void DFS(int leftRemain, int rightRemain, List<Character> res) {
		if(rightRemain == 0) {
			printBlock(res);
		}		
		// deal with '{'
		if(leftRemain > 0) {
			res.add('{');
			DFS(leftRemain-1, rightRemain, res);
			res.remove(res.size() - 1);
		}	
		// deal with '}'
		if(rightRemain > leftRemain) {
			res.add('}');
			DFS(leftRemain, rightRemain-1, res);
			res.remove(res.size() - 1);
		}			
	}
	
	public void printBlock(List<Character> res) {
		int indentation = 0;
		for(int i = 0; i < res.size(); i++) {
			if(res.get(i) == '{') {
				printSpace(indentation);
				System.out.println("if{");				
				indentation += 2;
			}else {
				indentation -= 2;
				printSpace(indentation);
				System.out.println("}");				
				indentation -= 2;
			}
		}
	}
	public void printSpace(int identation) {
		for(int i = 0; i < identation; i++) {
			System.out.print(' ');
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintNParisIfBlocks print = new PrintNParisIfBlocks();
		print.printNParisIfBlocks(2);
		
	}

}
