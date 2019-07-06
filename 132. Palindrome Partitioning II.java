class Solution {
    public int minCut(String s) {
        int len = s.length();
        if (len == 0) return 0;
        boolean[][] dp = new boolean[len][len];
        int[] res = new int[len];
        for (int i = 0; i < len; i++){
            res[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--){
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
                if (dp[j][i]){
                    res[i] = Math.min(res[i], j == 0 ? 0 : res[j-1] + 1);
                }

            }
        }
        return res[len-1];
    }
}