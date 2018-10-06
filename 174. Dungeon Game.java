class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n];
        //dp[n-1] = dungeon[m-1][n-1] >= 0 ? 1 : 1 - dungeon[m-1][n-1];
        dp[n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
        for (int j = n-2; j >= 0; j--){
            //dp[j] = dungeon[m-1][j] >= dp[j+1] ? 1 : dp[j+1] - dungeon[m-1][j];
            dp[j] = Math.max(1, dp[j+1] - dungeon[m-1][j]);
        }
        for (int i = m-2; i >= 0; i--){
            //dp[n-1] = dungeon[i][n-1] >= dp[n-1] ? 1 : dp[n-1] - dungeon[i][n-1];
            //System.out.println(i + "," + (n-1) + ":" + dp[n-1]);
            dp[n-1] = Math.max(1, dp[n-1] - dungeon[i][n-1]);
            for (int j = n-2; j >= 0; j--){
                int right = Math.max(1, dp[j+1] - dungeon[i][j]);//dungeon[i][j] >= dp[j+1] ? 1 : dp[j+1] - dungeon[i][j];
                int down = Math.max(1, dp[j] - dungeon[i][j]);//dungeon[i][j] >= dp[j] ? 1 : dp[j] - dungeon[i][j];
                dp[j] = Math.min(right, down);
                //System.out.println(i + "," + j + ":" + dp[j]);
            }
        }
        return dp[0];
    }
}