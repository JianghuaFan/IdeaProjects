package BinarySearch;

public class SmallestElementLargeraThanTarget636 {
    // HighLevel : binary search
    // Clarify: is there duplicate numbers, if it is, which one should I return
    // step1: compare mid number with target, leftBound would be 0, rightBound would be array.length - 1
    // step2: if smaller or equal than target(meaning target is in the right part), left = mid + 1
    // step3: if greater than target(meaning target is in the left part) : right = mid(maybe the answer)
    // post process the last two numbers
    // TC: O(logn) SC: O(1)
    public int smallestElementLargerThanTarget(int[] array, int target) {
        // base case:
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(array[mid] <= target){
                left = mid + 1;
            }else{
                right =  mid;
            }
        }
        // post process
        if(array[left] > target){
            return left;
        }
        if(array[right] > target){
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,5,6};
        int target = 4;
        SmallestElementLargeraThanTarget636 smallestElementLargeraThanTarget636 = new SmallestElementLargeraThanTarget636();
        System.out.println(smallestElementLargeraThanTarget636.smallestElementLargerThanTarget(array, target));
    }
}
