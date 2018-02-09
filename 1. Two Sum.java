public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(map.containsKey(nums[i])){
                int left = map.get(nums[i]);
                return new int[]{left, i};
            }else{
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}