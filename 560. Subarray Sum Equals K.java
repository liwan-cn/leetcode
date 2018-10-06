class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ret = 0;
        int lastKey = 0;
        for (int i = 0; i < nums.length; i++){
            int nowKey = lastKey + nums[i];
            ret += map.getOrDefault(nowKey - k, 0);
            map.put(nowKey, map.getOrDefault(nowKey, 0) + 1);
            //System.out.println(nowKey + ":" +map.getOrDefault(nowKey - k, 0));
            lastKey = nowKey;
        }
        return ret;
    }
}