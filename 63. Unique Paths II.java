class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++){
            if (obstacleGrid[i][0] == 1) dp[0] = 0;
            for(int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}