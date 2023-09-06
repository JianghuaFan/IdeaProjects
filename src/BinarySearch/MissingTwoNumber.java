package BinarySearch;

import java.util.Arrays;

public class MissingTwoNumber {
 public int[] missingTwoNumber(int[] array){
     // high level: binary search
     // int[] array: 0 1 3 4 6 7
     // index:       0 1 2 3 4 5
     // diff:        0 0 1 1 2 2
     // find the position of diff 1 and diff 2 two boundaries,the first occurrence of diff 1 and diff2 are the two missing numbers
    // TC: O(2 * logn)
     int[] res = new int[2];
    int left1 = 0;
    int right1 = array.length - 1;
    while(left1 < right1){
        int mid1 =  left1 + (right1 - left1) / 2;
        if(array[mid1] == mid1){// case 1: mid is same as array[mid], target in the right part
            left1 = mid1 + 1;
        }else{
            right1 = mid1;
        }
    }
    res[0] = array[right1] - 1;
    int left2 = 0;
    int right2 = array.length - 1;
    while (left2 < right2){
        int mid2 =  left2 + (right2 - left2) / 2;
        if(array[mid2] == mid2 + 1){// case 1: mid is same as array[mid], target in the right part
            left2 = mid2 + 1;
        }else{
            right2 = mid2;
        }
    }
    res[1] = array[right2] - 1;
    return res;
 }

    public static void main(String[] args) {
        int[] array = { 0, 1, 3, 4, 6, 7};
        MissingTwoNumber missingTwoNumber = new MissingTwoNumber();
        System.out.println(Arrays.toString(missingTwoNumber.missingTwoNumber(array)));
    }
}
