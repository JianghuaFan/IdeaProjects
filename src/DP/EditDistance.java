package DP;

public class EditDistance {
	 public int editDistance(String one, String two) {
		   // Write your solution here

//		int[][] M = new int[one.length()+1][two.length()+1];
//		//base case:
//		if(one.length() == 0){
//			return two.length();
//		}
//		if(two.length() == 0){
//			return one.length();
//		}
//		M[0][0] = 0;
//		// induction rule:
//		for(int i = 0; i <= one.length(); i++){
//			for(int j = 0; j <= two.length(); j++){
//				if(i == 0) {
//					M[i][j] = j;
//				}else if(j == 0) {
//					M[i][j] = i;
//				}else if(one.charAt(i-1) == two.charAt(j-1)) {
//					M[i][j] = M[i-1][j-1];
//				}else{
//					int replace = M[i-1][j-1] + 1;
//					int delete = M[i-1][j] + 1;
//					int insert = M[i][j-1] + 1;
//					M[i][j] = Math.min(Math.min(replace, delete), insert);	
//				}
//			}
//		}
////		for(int i = 0; i <= one.length(); i++){
////			for(int j = 0; j <= two.length(); j++){
////				System.out.print(M[i][j]);
////			}
////			System.out.println();
////		}
//			
//		return M[one.length()][two.length()];
		
		if(one.length() == 0){
		      return two.length();
		    }
		    if(two.length() == 0){
		      return one.length();
		    }
		    int[][] M = new int[one.length()+1][two.length()+1];
		    M[0][0] = 0;
		    for(int i = 0; i <= one.length(); i++){
		      for(int j = 0; j <= two.length(); j++){
		        if(i == 0){
		          M[i][j] = j;
		        }else if(j == 0){
		          M[i][j] = i;
		        }else if(one.charAt(i-1) == two.charAt(j-1)){
		          M[i][j] = M[i-1][j-1];
		        }else {
		        	int replace = M[i-1][j-1] + 1;
			        int delete = M[i-1][j] + 1;
			        int insert = M[i][j-1] + 1;
			        M[i][j] = Math.min(Math.min(replace,delete), insert);
		        }		        
		      }
		    }
		    return M[one.length()][two.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String one = "sigh";
		String two = "asith";
		EditDistance edit = new EditDistance();
		System.out.println(edit.editDistance(one, two));
	}

}
