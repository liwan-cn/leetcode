class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minx = m, miny = n;
        for (int i = 0; i < ops.length; i++){
            minx = Math.min(minx, ops[i][0]);
            miny = Math.min(miny, ops[i][1]);
        }
        return minx * miny;
    }
}