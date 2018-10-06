class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int res = 0, i = 0;
        while (miss <= (long)n){
            if (i < nums.length && (long)nums[i] <= miss){
                miss += (long)nums[i++];
            } else {
                miss += miss;
                res ++;
            }
        }
        return res;
    }
}