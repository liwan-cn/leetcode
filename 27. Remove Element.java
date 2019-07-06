class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for (int i = 0, len = nums.length; i < len; i++){
            if(nums[i] != val){
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }
}