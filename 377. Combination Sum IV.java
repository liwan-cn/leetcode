class Solution {
    private Map<Integer, Integer> map = null;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        map = new HashMap<>();
        map.put(0, 1);
        return helper(nums, target);
    }
    private int helper(int[] nums, int target){
        if (map.containsKey(target))
            return map.get(target);
        int res = 0;
        for (int i = 0; i < nums.length && target >= nums[i]; i++){
            res += helper(nums, target - nums[i]);
        }
        map.put(target, res);
        return res;
    }
}