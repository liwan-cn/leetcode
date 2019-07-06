class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        for (int i = 1; i < nums.length-1; i++){
            if(nums[i] != nums[i-1] || nums[i] != nums[i+1])
                nums[cnt++] = nums[i];
        }
        if (cnt < nums.length) nums[cnt++] = nums[nums.length-1];
        return cnt;
    }
}