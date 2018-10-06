class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < (nums.length >> 1); i++){
            ret += nums[i<<1];
        }
        return ret;
    }
}