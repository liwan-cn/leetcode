class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < Math.abs(S)) return 0;

        //a+b=sum, a-b=S ==> a=(sum+S)/2 或者 b=(sum-S)/2
        //尽可能减少dp数组的大小 target = min(a, b)
        if (S < 0) sum += S;
        else if (S > 0) sum -= S;

        //和为奇数 不存在
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