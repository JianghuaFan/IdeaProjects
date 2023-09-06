package ArrayMatrix;

import java.util.Arrays;

public class FindFirstLastOccurenceTarget {
    public int[] find(int[] array, int target){
        int leftBound = findFirst(array, target);
        int rightBound = findLast(array, target);
        return new int[]{leftBound, rightBound};
    }
    public int findFirst(int[] array, int target){
        int left = 0;
        int right = array.length -  1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] < target){
                left = mid + 1;
            } else if(array[mid] > target){
                right = mid - 1;
            }else{
                right = mid;
            }
        }
        if(array[left] == target){
            return left;
        }else if(array[right] == target){
            return right;
        }else{
            return -1;
        }
    }
    public int findLast(int[] array, int target){
        int left = 0;
        int right = array.length -1;
        while(left < right - 1){
            int mid = left + (right - left) / 2;
            if(array[mid] < target){
                left = mid + 1;
            } else if(array[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        if(array[right] == target){
            return right;
        }else if(array[left] == target){
            return left;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] array = {5,7,7,8,8,10};
        int target = 8;
        FindFirstLastOccurenceTarget findFirstLastOccurenceTarget = new FindFirstLastOccurenceTarget();
        System.out.println(Arrays.toString(findFirstLastOccurenceTarget.find(array, target)));
    }
}
