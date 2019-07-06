class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        //dp[i][j] 表示进入(i, j) 的血量至少是多少
        int[] dp = new int[n];
        dp[n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        for (int j = n-2; j >= 0; j--){
            dp[j] = Math.max(1, dp[j+1] - dungeon[m-1][j]);
        }
        for (int i = m-2; i >= 0; i--){
            dp[n-1] = Math.max(1, dp[n-1] - dungeon[i][n-1]);
            for (int j = n-2; j >= 0; j--){
                int right = Math.max(1, dp[j+1] - dungeon[i][j]);
                int down = Math.max(1, dp[j] - dungeon[i][j]);
                dp[j] = Math.min(right, down);
            }
        }
        return dp[0];
    }
}