class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int re = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(sum - target) < Math.abs(re - target)) 
                    re = sum;
                if (sum > target) hi--;
                else lo++;
            }
        }
        return re;
    }
}