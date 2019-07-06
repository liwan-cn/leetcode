class Solution {
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        if (len <= 1) return len;
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int res = 1, end = pairs[0][1];
        for (int i = 1; i < len; i++){
            if (pairs[i][0] > end){
                end = pairs[i][1];
                res++;
            }
        }
        return res;
    }
}