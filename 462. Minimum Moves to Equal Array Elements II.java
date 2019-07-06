class Solution {
    public int minMoves2(int[] nums) {
        parttition(nums, nums.length >> 1, 0, nums.length-1);
        int res = 0;
        for (int num : nums){
            res += Math.abs(num - nums[nums.length >> 1]);
        }
        return res;
    }
    private void parttition(int [] nums, int k, int S, int E){
        if (S > E) return;
        int s = S, e = E;
        int p = nums[s];
        while (s < e) {
            while (e > s && nums[e] > p) e--;
            if (s < e) nums[s] = nums[e];
            while (e > s && nums[s] <= p) s++;
            if (s < e) nums[e] = nums[s];
        }
        nums[s] = p;
        if (s == k) return;
        if (s < k) parttition(nums, k, s+1, E);
        else parttition(nums, k, S, s-1);
    }
}