class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int remain = 0, res = 0;
        for (int time : timeSeries){
            res += (time + duration) - Math.max(remain, time);
            remain = time + duration;
        }
        return res;
    }
}