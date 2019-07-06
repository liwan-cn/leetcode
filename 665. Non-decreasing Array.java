class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1, l = nums.length; i < l; i++){
            if (nums[i] < nums[i-1]){
                if (i >= 2 && nums[i] < nums[i-2])
                    nums[i] = nums[i - 1];
                else
                    nums[i-1] = nums[i];
                cnt ++;
                if (cnt > 1) return false;
            }
        }
        return true;
    }
}