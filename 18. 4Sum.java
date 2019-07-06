class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                int s = j + 1, e = nums.length - 1, sum = target - nums[i] - nums[j];
                while(s < e){
                    if (nums[s] + nums[e] == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[s], nums[e]));
                        while (s < e && nums[s] == nums[s+1]) s++;
                        while (s < e && nums[e] == nums[e-1]) e--;
                        s++; e--;
                    } else if (nums[s] + nums[e] < sum) {
                        s++;
                    } else {
                        e--;
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j+1]) j++;
            }
            while (i < nums.length - 3 && nums[i] == nums[i+1]) i++;
        }
        return res;
    }
}