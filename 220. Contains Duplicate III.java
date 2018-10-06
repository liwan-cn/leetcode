class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <  1 || t < 0) return false;
        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            long mapNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = mapNum / ((long) t + 1);
            if (buckets.containsKey(bucket))
                return true;
            if (buckets.containsKey(bucket - 1) && mapNum - buckets.get(bucket - 1) <= t)
                return true;
            if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - mapNum <= t)
                return true;
            if (buckets.size() >= k){
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                buckets.remove(lastBucket);
            }
            buckets.put(bucket, mapNum);
        }
        return false;
    }
}