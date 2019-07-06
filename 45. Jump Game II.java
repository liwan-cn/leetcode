class Solution {
    public int jump(int[] nums) {
        int step = 0, lastReach = 0, nowReach = 0;
        for (int i = 0, len = nums.length - 1; i < len; i++){
            nowReach = Math.max(nowReach, i + nums[i]);
            if (nowReach >= len) return step + 1;
            if (i == lastReach){
                step ++;
                lastReach = nowReach;
            }
        }
        return step;
    }
}