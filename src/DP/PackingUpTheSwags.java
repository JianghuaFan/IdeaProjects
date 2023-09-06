package DP;
/*
Q3. Packing Up the Swags （25分值，20分钟）
Our company is going to distribute swags at the recruiting event.
We will put the swags into square-shaped boxes. Each box has to be completely filled so that the swags wouldn’t break during transportation.
For example, a box can contain 1 swag, 4 swags, 9 swags, etc. (The boxes can be sufficiently large.)
                        num (20)
              /      /        |      \
          4*4(4)   3*3(11)  2*2(16)  1*1(19)
       /            |    \
     2*2(0)     3*3 .....
     every level: choose one box
     branch: which box to choose
     TC: O(
 */
import java.util.ArrayList;
import java.util.List;

public class PackingUpTheSwags {
    public int minBoxDFS(int num){
        int[] min = new int[]{Integer.MAX_VALUE};
        List<Integer> cur = new ArrayList <>();
        dfs( num, cur, min);
        return min[0];
    }

    private void dfs( int  num, List<Integer> cur, int[] min){
        // base case
        if(num == 0){
                min[0] = Math.min(min[0], cur.size());
                if(cur.size() == min[0]){
                    System.out.println(cur);
                }
                return;
        }
        for (int i = (int)Math.sqrt(num); i >= 1; i--){
//            if(num >= i * i){
                cur.add(i);
                dfs(num - i * i, cur, min);
                cur.remove(cur.size() - 1);
            }
//        }
    }

    public int minBoxDP(int num){
        int[] min = new int[num + 1];
        // base case:
        min[0] = 0;// 不写也行，零假空
        min[1] = 1;
        for(int i = 2; i <= num; i++){
            int curMin = Integer.MAX_VALUE;
//         左大段是j， 右小段是i - j
            for(int j = 0; j < i; j++){
                if(Math.sqrt(i - j) % 1 == 0){
                    curMin = Math.min(curMin, min[j] + 1);
                }
            }
            min[i] = curMin;
        }
        // 第二种写法： 左大段是表里找，右小段直接就是j*j, i- j*j 就是左大段
//        for(int i = 2; i <= num; i++){
//            min[i] = i;// 最多需要i个箱子
//            for(int j = 1; j*j <= num; j++){
//                min[i] = Math.min(min[i], min[i - j*j] + 1);
//            }
//        }
        return min[num];
    }

    public int minDp(int n){
        // base case
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        // induction rule
        for(int i = 0; i <= n ; i++){
            dp[i] = i;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        int num = 3;
        PackingUpTheSwags packingUpTheSwags = new PackingUpTheSwags();
        System.out.println(packingUpTheSwags.minBoxDP(num));
//        System.out.println(packingUpTheSwags.minBoxDFS(num));
        System.out.println(packingUpTheSwags.minDp(num));

    }
}
