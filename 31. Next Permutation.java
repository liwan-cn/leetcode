class Solution {
    public void nextPermutation(int[] nums) {
        int pos = nums.length - 1;
        int minPos = nums.length;
        while(--pos >= 0 && nums[pos] >= nums[pos+1]);
        if(pos >= 0){
            while(nums[--minPos] <= nums[pos]);
            int tmp = nums[pos];
            nums[pos] = nums[minPos];
            nums[minPos] = tmp;
        }
        Arrays.sort(nums, pos+1, nums.length);
    }
}