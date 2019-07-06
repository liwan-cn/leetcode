class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int ls = s.length(), lp = p.length();
        boolean [][]dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;
        for (int i = 0; i < lp; i++) {
            dp[0][i+1] = p.charAt(i) == '*' && dp[0][i-1];
        }
        for (int i = 0; i < ls; i++) {
            for (int j = 0; j < lp; j++) {
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    //  x*表示0个字符
                    dp[i+1][j+1] = dp[i+1][j-1];
                    if (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.') {
                        //x*表示0,1,多个字符
                        dp[i+1][j+1] = (dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1]);
                    }
                }

            }
        }
        return dp[ls][lp];
    }
}
/*
1, If p.charAt(j) == s.charAt(i) :  
            dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : 
            dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
    1   if p.charAt(j-1) != s.charAt(i) :
            dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
    2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
            dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
*/