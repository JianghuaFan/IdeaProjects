package ArrayMatrix;
/*
849. Maximize Distance to Closest Person  Medium

You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to the closest person.
Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:
Input: seats = [1,0,0,0]
Output: 3
 */
public class MaximizeDistancetoClosestPerson {
    //TC: O(n) SC: O(1)
    public int maxDistToClosest(int[] seats) {
        if(seats == null || seats.length == 0){
            return -1;
        }
        int longest = 0;
        int cur = 0;
        int res = 0;
        int start = 0;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0){
                cur++;
                if(cur >= res){
                    longest = cur;
                    start = i - longest + 1;
                    // 如果找到的位置是在最左边或者最右边，则直接返回最长距离
                    if(start == 0 || i == seats.length - 1){
                        res = Math.max(res,longest);
                    }else{
                        res = Math.max(res, ( longest + 1 )/ 2);
                    }
                }
            }
            else{
                cur = 0;
            }
        }
        return res;
    }
    public int maxDistToClosestLeetCodeAnswer(int[] seats) {
        int N = seats.length;
        int K = 0; //current longest group of empty seats
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                K = 0;
            } else {
                K++;
                ans = Math.max(ans, (K + 1) / 2);
            }
        }

        for (int i = 0; i < N; ++i)  if (seats[i] == 1) {
            ans = Math.max(ans, i);
            break;
        }

        for (int i = N-1; i >= 0; --i)  if (seats[i] == 1) {
            ans = Math.max(ans, N - 1 - i);
            break;
        }

        return ans;
    }

    public static void main(String[] args) {
        MaximizeDistancetoClosestPerson maximizeDistancetoClosestPerson = new MaximizeDistancetoClosestPerson();
        int[] array = {1,0,0,0,1,0,1};
        int[] array1 = {1,0,0,1};
        int[] array2 = {0,1};
        int[] array3 = {1,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0};
        int[] array4 = {1,1,0,0,0,1,1,0,0,1,0};
//        System.out.println(maximizeDistancetoClosestPerson.maxDistToClosest(array));
//        System.out.println(maximizeDistancetoClosestPerson.maxDistToClosest(array3));
//        System.out.println(maximizeDistancetoClosestPerson.maxDistToClosest(array2));
        System.out.println(maximizeDistancetoClosestPerson.maxDistToClosest(array4));
    }
}
