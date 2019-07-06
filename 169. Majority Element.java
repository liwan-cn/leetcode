class Solution {
    public int majorityElement(int[] nums) {
        int ret = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ret) {
                cnt ++;
            } else {
                if (cnt == 1) ret = nums[++i];
                else cnt --;
            }
        }
        return ret;
    }
}