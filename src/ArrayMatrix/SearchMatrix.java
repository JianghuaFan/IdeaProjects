package ArrayMatrix;

public class SearchMatrix {	
	    public static boolean searchMatrix(int[][] matrix, int target) {
	        int m = matrix.length, n = matrix[0].length;
	        int i = 0, j = n-1;
	        while(i < m && j >= 0){//从右上角开始找起，比target大则向左否则向下            
	                if(target == matrix[i][j]){
	                    return true;
	                }else if(target < matrix[i][j]){
	                    j--;
	                }else{
	                    i++;
	                }
	            }     
	        return false;
	        }           
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19}};
		int target = 3;
		System.out.print(searchMatrix(matrix,target));

	}

}
