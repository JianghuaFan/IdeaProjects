package BinarySearch;
/*
2 3 6 8 12 15 19  17 13 9 7 4 2 1
Ascending       || Descending
target : 9
 */
public class FindTargetInPeakArray {
    public int findTargetInPeakArray(int[] array, int target){
        // step 1: find the peak number of the array
        // step 2: run two times of binary search in two parts
        int peak = findPeak(array);
        System.out.println("peakIndex:" + peak);
        //step 2: run two binary search:
        int targetInLeft = findTarget(array, 0, peak, target);
        System.out.println("targetInLeft:" + targetInLeft );
        int targetInRight = findTarget(array, peak + 1, array.length - 1, target);
        System.out.println("targetInRight:" + targetInRight );
        return targetInLeft != -1 ? targetInLeft : targetInRight;
    }

    private int findTarget(int[] array, int start, int end, int target) {
        int left = start;
        int right = end;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] > target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findPeak(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1 ;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] > array[mid - 1] && array[mid] > array[mid] + 1){
                return array[mid];
            }else if(array[mid] < array[mid - 1]){
                right = mid; // case:  search to left half
            }else{ // case: search to right half
                left = mid;
            }
        }
        //post processing:
        if(array[left] > array[right]){
            return left;
        }else{
            return right;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6, 12, 15, 19,  17, 13, 9, 7, 4, 2, 1};
        int target = 9;
        FindTargetInPeakArray findTargetInPeakArray = new FindTargetInPeakArray();
        System.out.println(findTargetInPeakArray.findTargetInPeakArray(array, target));
    }
}
