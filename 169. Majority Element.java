class Solution {
    public int majorityElement(int[] nums) {
        int ret = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == ret) cnt ++;
            else {
                cnt --;
                if (cnt == 0) {
                    ret = nums[++i];
                    cnt ++;
                }
            }
        }
        return ret;
    }
}