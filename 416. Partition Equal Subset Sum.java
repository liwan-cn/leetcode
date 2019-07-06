class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        sum = (sum >> 1);

        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (int num : nums){
            for (int i = sum; i >= num; i--){ // 必须从大到小, 否则同一个num可能会计算两遍
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[sum];
    }
}