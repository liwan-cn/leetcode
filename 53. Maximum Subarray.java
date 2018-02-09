class Solution {
    public int maxSubArray(int[] nums) {
        int last = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(last > 0) {
                last = last + nums[i];
            }
            else{
                last = nums[i];
            }
            max = max > last ? max : last;
        }
        return max;
    }
}