class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        
        for (int x : nums) sum += x;
        if (sum < Math.abs(S)) return 0;
        
        if (S < 0) sum += S;
        else if (S > 0) sum -= S; //尽可能减少dp数组的大小
        
        if ((sum & 1) == 1) return 0;
        sum = (sum >> 1);
        
        int[] dp = new int[sum+1];
        dp[0] = 1;
        
        for (int num : nums){
            for (int i = sum; i >= num; i--){ // 必须从大到小, 否则同一个num可能会计算两遍
                dp[i] += dp[i-num];
            }
        }
        return dp[sum];
    }
}