class Solution {
    public int arrayNesting(int[] nums) {
        int max  = 0;
        for (int i = 0; i < nums.length; i++){
            int size = 0;
            for (int k = i; nums[k] >= 0; size++){
                int tmp = nums[k];
                nums[k] = -1;
                k = tmp;
            }
            max = Math.max(max, size);
        }
        return max;
    }
}