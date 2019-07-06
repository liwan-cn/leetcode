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
        for (int s = pos + 1, e = nums.length - 1; s < e; s ++, e --){
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
        }
    }
}