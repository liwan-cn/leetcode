class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        for (int i = 0, len = nums.length; i < len; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }
}