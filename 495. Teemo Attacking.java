class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int remain = 0, res = 0;
        for (int x : timeSeries){
            res += (x + duration) - Math.max(remain, x);
            remain = x + duration;
        }
        return res;
    }
}