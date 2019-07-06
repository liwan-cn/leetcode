class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        List<int[]> res = new ArrayList<>();
        int []pre = null;
        for (int []now : intervals){
            if (pre == null || now[0] > pre[1]){
                res.add(now);
                pre = now;
            } else if (now[1] > pre[1]){
                pre[1] = now[1];
            }
        }
        int[][] arr = new int[res.size()][2];
        return res.toArray(arr);
    }
}