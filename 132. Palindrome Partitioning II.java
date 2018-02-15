class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        if (len == 0) return 0;
        for (int i = len-1; i >= 0; i--){
            dp[i][i] = true;
            for (int j = i+1; j < len; j++){
                if (j == i+1) 
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        int[] res = new int[len];
        res[0] = 0;
        for (int i = 1; i < len; i++){
            if (dp[0][i]) {
                res[i] = 0;
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = i; j > 0; j--){
                if (dp[j][i])
                    min = Math.min(min, res[j-1]);
            }
            res[i] = min + 1;
            //System.out.println(res[i]);
        }
        return res[len-1];
    }
}