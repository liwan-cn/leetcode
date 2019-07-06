class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        int head = 0, tail = -1, max = 0;
        for (int i = 0; i < l; i++){
            for (int j = i; j >= 0; j--){
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
                if (dp[j][i] && i - j + 1 > max) {
                    head = j; tail = i;
                    max = i -j + 1;
                }
            }
        }
        return s.substring(head, tail + 1);
    }
}