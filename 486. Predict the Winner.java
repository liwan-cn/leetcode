class Solution {
    public boolean PredictTheWinner(int[] nums) {
        //dp[i][j] 表示在i-j的子序列中先手比后手的得分高的分数
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        for (int i = n - 2; i >= 0; i--)
            for (int j = i + 1; j < n; j++)
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        return dp[0][n - 1] >= 0;
    }
}