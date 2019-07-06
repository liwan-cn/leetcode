class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int  i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int s = i + 1, e =  nums.length - 1, sum = 0 - nums[i];
                while (s < e) {
                    if (nums[s] + nums[e] == sum) {
                        res.add((Arrays.asList(nums[i], nums[s], nums[e])));
                        while (s < e && nums[s] == nums[s+1]) s++;
                        while (s < e && nums[e] == nums[e-1]) e--;
                        s++; e--;
                    } else if (nums[s] + nums[e] < sum) {
                        s++;
                    } else {
                        e--;
                    }

                }
            }
        }
        return res;
    }
}