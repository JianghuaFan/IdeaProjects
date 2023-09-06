package BinarySearch;

public class FindBadVersion278 {
	
	    public static int firstBadVersion(int n) {
	        int low = 1, hi = n;
	        while(low < hi){
	            int mid = low + (hi-low)/2;
	            if(isBadVersion(mid)){
	                 hi = mid;
	            }else{
	                low = mid + 1;
	            }
	        }
	        return low;
	    }
	private static boolean isBadVersion(int mid) {
			// TODO Auto-generated method stub
		//if(mid == false)
			return false;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.print(firstBadVersion(n));

	}

}
