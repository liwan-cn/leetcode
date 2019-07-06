class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        res.add(newInterval);
        for (int[] now : intervals){
            if (now[1] < newInterval[0]){
                res.add(res.size() - 1, now);
            } else if (newInterval[1] < now[0]){
                res.add(now);
            } else {
                newInterval[0] = Math.min(now[0], newInterval[0]);
                newInterval[1] = Math.max(now[1], newInterval[1]);
            }
        }
        int[][] arr = new int[res.size()][2];
        return res.toArray(arr);
    }
}