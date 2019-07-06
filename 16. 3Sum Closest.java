class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int re = nums[0] + nums[1] + nums[2];
        for (int  i = 0; i < nums.length - 2; i++) {
            int s = i + 1, e =  nums.length - 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (Math.abs(sum - target) < Math.abs(re - target)) re = sum;
                if (sum > target) e--;
                else s++;
            }
        }
        return re;
    }
}