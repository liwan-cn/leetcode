class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls + 1][lp+ 1];
        dp[0][0] = true;
        for (int i = 0; i < lp && p.charAt(i) == '*'; i++) {
            dp[0][i+1] = true;
        }
        for (int i = 0; i < ls; i++){
            for (int j = 0; j < lp; j++) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }else if (p.charAt(j) == '*') {
                    //  *表示0个或者多个字符
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1];
                }
            }
        }
        return dp[ls][lp];
    }
}