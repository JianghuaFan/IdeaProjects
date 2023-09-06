package ArrayMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
207. Majority Number II
Medium
Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.

Assumptions

The given array is not null
Examples

A = {1, 2, 1, 2, 1}, return [1, 2]
A = {1, 2, 1, 2, 3, 3, 1}, return [1]
A = {1, 2, 2, 3, 1, 3}, return []
 */
public class MajorityNumberII {
    public List<Integer> majority(int[] array){
        List<Integer> res = new ArrayList<>();
//
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MAX_VALUE;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == candidate1){
                count1++;
            }else if(array[i] == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = array[i];
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = array[i];
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        int k = array.length / 3;
        int c1 = 0;
        int c2 = 0;
        for(int num : array){
            if(num == candidate1){
                c1++;
            }
            if(num == candidate2){
                c2++;
            }
        }
        if(c1 > k){
            res.add(candidate1);
        }
        if(c2 > k){
            res.add(candidate2);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] array = {2,1,1,3,1,4,5,6};
        int[] array = {1,1};
        MajorityNumberII majorityNumberII = new MajorityNumberII();
        System.out.println(majorityNumberII.majority(array));
    }
}
