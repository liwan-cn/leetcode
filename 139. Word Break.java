class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
    /*  Time Limit Exceeded
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return backtrack(wordSet, s, 0, s.length())
    }
    public boolean backtrack(Set<String> wordSet, String s, int start, int end){
        if (start == end) return true;
        for (int i = start+1; i <= end; i++){
            String key = s.substring(start, i);
            if (!wordSet.contains(key)) continue;
            if (backtrack(wordSet, s, i, end))
                return true;
        }
        return false;
    }
    */
}