package BinarySearch;

public class binarySearch {
	public static int binarySearch1(int[] nums, int target) {
		  if (nums == null || nums.length == 0)
		    return -1;
		  int left = 0;
		  int right = nums.length - 1;
		  
		  
		  while (left <= right) {
		    int mid = left + ( right - left ) / 2;
		    if (nums[mid] == target){
		      return mid;
		    }else if (nums[mid] < target) {
		      left = mid + 1;
		    } else{ 
		      right = mid - 1;
		    }
		  }
		    return -1;
		}

	public static int binarySearch(int[] array, int target) {
		//   // Write your solution here
		//   if(array == null || array.length == 0){
		//     return -1;
		//   }
		//   int left = 0;
		//   int right = array.length - 1;
		//   while( left <= right) {
		//     int mid = left + (right - left) / 2;
		//     if(array[mid] == target){
		//       return mid;
		//     }else if(array[mid] < target) {
		//       left = mid + 1;
		//     }else {
		//       right = mid - 1;
		//     }
		//   }
		//   return -1;
		// }
		// hightlight binary search, compare the middle element with the target, to narrow down the search area
		if(array == null || array.length == 0){
			return -1;
		}
		int left = 0, right = array.length - 1;
		int mid = left + (right - left) / 2;
		while(left <= right){
			if(target == array[mid]){
				return mid;
			}else if(target < array[mid]){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,5,6,6,9,16};
		int target = 5;
		System.out.print(binarySearch(nums,target));
        
	}

}
