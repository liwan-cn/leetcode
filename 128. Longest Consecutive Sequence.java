class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer>  map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                int l = map.getOrDefault(num - 1, 0);
                int r = map.getOrDefault(num + 1, 0);
                int now = l + r + 1;
                map.put(num, now);
                map.put(num - l, now);
                map.put(num + r, now);
                res = Math.max(res, now);
            }
        }
        return res;
    }
}