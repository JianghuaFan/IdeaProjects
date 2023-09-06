package DP;

import java.util.List;
/*
329. Longest Increasing Path in a Matrix
Hard
7.6K
112
company
Google
company
DoorDash
company
TikTok
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Example 1:
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
 */
public class LongestIncreasingPathinaMatrix {
    public static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longest(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        if(matrix == null || row == 0 || col == 0){
            return 0;
        }
        // dp 物理意义： 从i,j 这个点出发的最大升序路径， 返回值物理意义代表
        // 1 基本check （1）check 出界  （2） check是否升序  （3） check是否visited
        // 2 如果dp[i][j] 有意义，无需再往下dfs直接只用dp[i][j]结果
        // 3 正常处理 （i，j）（1）mark visited （2） update curMax（四个方向返回值） （3） update dp[i][j]
        // 4 Back- tracking  unmark visited
        // TC: O(V+E) SC: O(V)
        // induction rule: 站在i，j这个点的dfs得到的最大路径
        // base case: dp[0][0] = 1
        // result: globalMax

        int[][] dp = new int[row][col];
        int res = 0;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int maxLen = dfs(i,j, -1, visited, matrix, dp);
                res = Math.max(res, maxLen);
            }
        }
        return res;
    }
    private int dfs(int x, int  y, int pre, boolean[][] visited, int[][] matrix, int[][] dp){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length){
            return 0;
        }
        if(matrix[x][y] <= pre){// 检查升序
            return 0;
        }
        if(visited[x][y]){
            return dp[x][y];
        }
        if(dp[x][y] != 0){
            return dp[x][y];
        }
        visited[x][y] = true;
        int curMax = 1;
        for(int[] dir : DIRS){
            int neiX = x + dir[0];
            int neiY = y + dir[1];
            curMax = Math.max(curMax, dfs(neiX, neiY, matrix[x][y], visited, matrix, dp) + 1);
        }
        visited[x][y] = false;
        dp[x][y] = curMax;
        return dp[x][y];
    }

// 优化以上算法，因为dp[i]][j] 有意义的话表示i，j已被访问，所以不需要visited来标记，不需要backtracking了
    public int longestOptimizeSpace(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        if(matrix == null || row == 0 || col == 0){
            return 0;
        }
        int res = 0;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0;  j < col; j++){
                res = Math.max(res, dfsOptimize(matrix, i, j, dp));
            }
        }
        return res;
    }
/*
Time complexity : O(mn)O(mn)O(mn). Each vertex/cell will be calculated once and only once, and each edge will be visited once and only once.
The total time complexity is then O(V+E)O(V+E)O(V+E).
V is the total number of vertices and E
 is the total number of edges.
 In our problem, O(V)=O(mn), O(E)=O(4V)=O(mn).

Space complexity : O(mn). The cache dominates the space complexity
 */
    private int dfsOptimize(int[][] matrix, int i, int j, int[][] dp) {
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length){
            return 0;
        }
        int res = 1;
        for(int[] dir : DIRS){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[i][j] < matrix[x][y]){
                res = Math.max(res, dfsOptimize(matrix, x, y, dp) + 1);
            }
        }
        dp[i][j] = res;
        return dp[i][j];
    }


    public static void main(String[] args) {
        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
        LongestIncreasingPathinaMatrix longestIncreasingPathinaMatrix = new LongestIncreasingPathinaMatrix();
        System.out.println(longestIncreasingPathinaMatrix.longest(matrix));
        System.out.println(longestIncreasingPathinaMatrix.longestOptimizeSpace(matrix));
    }

}
