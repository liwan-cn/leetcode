class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        boolean[][] dp = new boolean[n][n];
    
        int head = 0, tail = 0, max = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            
                if (dp[i][j] && j - i + 1 > max) {
                    head = i; tail = j;
                    max = j - i + 1;
                }
            }
        }
        //System.out.println(head + ";" + tail);
        return  s.substring(head, tail+1);
    }
}