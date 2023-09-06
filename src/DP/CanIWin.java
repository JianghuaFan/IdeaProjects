package DP;
/*
657. Can I Win II
Medium
There is an array of positive integers, in which each integer represents a piece of Pizza’s size,
you and your friend take turns to pick pizza from either end of the array.
Your friend follows a simple strategy: He will always pick the larger one he could get during his turn.
The winner is the one who gets the larger total sum of all pizza.
Return the max amount of pizza you can get.

Assumption: If during your friend's turn, the leftmost pizza has the same size as the rightmost pizza, he will pick the rightmost one.

Example:

Input: [2,1,100,3]

Output: 102

Explanation: To win the game, you pick 2 first, then your friend will pick either 3, after that you could pick 100. In the end you could get 2 + 100 = 102, while your friend could only get 1 + 3 = 4.
 */
public class CanIWin {
    public boolean canWin(int[] nums) {
        // Write your solution here
        // TC: O(n^2)  SC: O(n^2)
        // corner case
        if(nums == null || nums.length == 0){
            return true;
        }
        int[][] win = new int[nums.length][nums.length];
        win[0][0] = nums[0];
        // case1:  I take nums[i], then friend take nums[i+1] if nums[i + 1] > nums[j], I got nums[i] + win[i + 2][j]
        //                         then friend take nums[j] if nums[i + 1] < nums[j], I got nums[i] + win[i + 1][j - 1]
        // case 2:
        // 填二维矩阵dp是从对角线往上填，
        for(int j = 0; j < nums.length; j++){
            for(int i = j; i >= 0; i--){
                // base case1:
                if(i == j){
                    win[i][j] = nums[i];
                }else if(j == i + 1){// base case2:
                    win[i][j] = Math.max(nums[i], nums[j]);
                }else{
                    // case1: 我吃I，then friend take nums[i+1] if nums[i + 1] > nums[j], I got nums[i] + win[i + 2][j]
                    //        then friend take nums[j] if nums[i + 1] < nums[j], I got nums[i] + win[i + 1][j - 1]
                    int chooseI = 0;
                    if(nums[i+1] > nums[j]){
                        chooseI = win[i+2][j] + nums[i];
                    }else{
                        chooseI = win[i+1][j-1] + nums[i];
                    }
                    // case 2: 我吃J
                    int chooseJ = 0;
                    if(nums[i] > nums[j - 1]){
                        chooseJ = win[i+1][j-1] + nums[j];
                    }else{
                        chooseJ = win[i][j - 2] + nums[j];
                    }
                    win[i][j] = Math.max(chooseI, chooseJ);
                }
            }
        }
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return win[0][nums.length-1] > (sum - win[0][nums.length-1]);
//        return win[0][nums.length - 1];
    }
    public int canWinII(int[] nums) {
        int[][] win = new int[nums.length][nums.length];
        win[0][0] = nums[0];
        // 填二维矩阵dp是从对角线右下往左上填，
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i; j < nums.length; j++){
                // base case 1: 只有一块pizza
                if(i == j){
                    win[i][j] = nums[i];
                }else if(i + 1 == j){
                    win[i][j] = Math.max(nums[i], nums[i+1]);
                }else{
                    // case 1: 我吃I
                    int chooseI = 0;
                    if(nums[i + 1] < nums[j]){
                        chooseI = nums[i] + win[i+1][j-1];
                    }else{
                        chooseI = nums[i] + win[i+2][j];
                    }
                    // case 2 : 我吃J
                    int chooseJ = 0;
                    if(nums[i] < nums[j-1]){
                        chooseJ = nums[j] + win[i][j-2];
                    }else{
                        chooseJ = nums[j] + win[i+1][j];
                    }
                    win[i][j] = Math.max(chooseI, chooseJ);
                }
            }
        }
        return win[0][nums.length - 1];
    }
    public static void main(String[] args) {
        int[] nums = {2,4,55,6,8};
//        int[] nums = {77,47,84,31,67,38,34,56,33,52,31,99,32,98,82,85,60};
        CanIWin can = new CanIWin();
        System.out.println(can.canWin(nums));
        System.out.println(can.canWinII(nums));
    }
}
