class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0, len = nums.length; i < len; i += 2)
            ret += nums[i];
        return ret;
    }
}