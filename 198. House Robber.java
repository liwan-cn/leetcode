class Solution {
    public int rob(int[] nums) {
        //maxY示 以 i 结尾 最大的金额
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int maxN = nums[0], maxY = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int tmp = maxY;
            //nums[i] + maxN 可以抢劫nums[i],  maxY 可以抢劫nums[i]
            maxY = Math.max(nums[i] + maxN, maxY);
            maxN = tmp;
        }
        return maxY;
    }
}