class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length-2; i++){
            if(nums[i] != nums[i+2])
                nums[cnt++] = nums[i];
        }
        for (int i = Math.max(nums.length-2, 0); i < nums.length; i++){
            nums[cnt++] = nums[i];
        }
        return cnt;
    }
}