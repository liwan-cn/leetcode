class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++){
            long value = (long) nums[i] - Integer.MIN_VALUE;
            long key = value / ((long) t + 1);
            if (buckets.containsKey(key))
                return true;
            if (buckets.containsKey(key-1) && value - buckets.get(key-1) <= t)
                return true;
            if (buckets.containsKey(key+1) && buckets.get(key+1) - value <= t)
                return true;
            if (buckets.size() >= k)
                buckets.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1));
            buckets.put(key, value);
        }
        return false;
    }
}