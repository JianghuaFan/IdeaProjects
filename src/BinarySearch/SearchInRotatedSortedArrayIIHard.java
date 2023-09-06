package BinarySearch;

public class SearchInRotatedSortedArrayIIHard {
	
		public static int search(int[] array, int target) {
		// Write your solution here
		if (array.length==0){
		return -1;
		}
		int left = 0;
		int right = array.length-1;
		while (left+1<right){
		int mid = left + (right-left)/2;
		if (array[left]==array[right]){
		right--;
		continue;
		}
		if (array[left]<=array[mid]){
		if (array[left]<=target && target<=array[mid]){
		right = mid;
		}else{
		left = mid+1;
		}
		}else{
		if (array[mid]<=target && target<=array[right]){
		left = mid;
		}else{
		right = mid-1;
		}
		}
		}
		if (array[left]==target){
		return left;
		}else if (array[right]==target){
		return right;
		}
		return -1;
		
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,1,1,1,1,3};
		System.out.print(search(array,3));
	}

}
