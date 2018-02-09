class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;
        int cnt = 0; // red count
        while (start <= end) {
            if (nums[start] == 0){
                nums[start++] = 1;
                nums[cnt++] = 0;
            } else if (nums[start] == 1){
                start++;
            } else {
                int tmp = nums[end];
                nums[end--] = 2;
                nums[start] = tmp;
            }
        }
    }
}