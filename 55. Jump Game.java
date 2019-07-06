class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0, len = nums.length; i < len; i++){
            if (max > len) return true;
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}