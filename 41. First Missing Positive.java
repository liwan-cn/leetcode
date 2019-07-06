class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0, l = nums.length;
        while (i < l) {
            if (nums[i] == i + 1 || nums[i] > l || nums[i] <= 0 || nums[nums[i] - 1] == nums[i]){
                i++;
            } else {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        i = 0;
        while(i < l && nums[i] == i+1) i++;
        return i + 1;
    }
}