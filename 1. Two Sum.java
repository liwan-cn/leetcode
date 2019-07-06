class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num2Pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (num2Pos.containsKey(target - nums[i])){
                return new int[]{num2Pos.get(target - nums[i]), i};
            }
            num2Pos.put(nums[i], i);
        }
        return null;
    }
}