class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int maxTmp = max, minTmp = min;
            max = Math.max(nums[i], Math.max(nums[i] * maxTmp, nums[i] * minTmp));
            min = Math.min(nums[i], Math.min(nums[i] * maxTmp, nums[i] * minTmp));
            res = Math.max(res, max);
        }
        return res;
    }
}