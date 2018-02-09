class Solution {
    public int numTrees(int n) {
        int[] ret = new int[n+1];
        ret[0] = 1; ret[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
            ret[i] += ret[j-1] * ret[i-j];
            }
        }
        return ret[n];
    }
}