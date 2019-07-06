class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);
        int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
        for (String word: wordSet) {
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        List<List<Integer>> reach = new ArrayList<>();
        List<String> list = new ArrayList<>();

        int len = s.length();
        for (int i = 0; i < len; i++)
            reach.add(new ArrayList<Integer>());
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int l = minLen; l <= maxLen && i >= l; l++){
                int j = i - l;
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    reach.get(j).add(i);
                }
            }
        }
        if (!dp[len]) return list;
        //System.out.println(reach.toString());
        genSentence(list, reach, s, "", 0);
        return list;
    }
    public void genSentence(List<String> list,  List<List<Integer>> reach, String s, String pre, int end){
        //System.out.println(pre);
        if (end == s.length()) {
            list.add(pre.substring(0, pre.length()-1));
            return;
        }
        for (int i : reach.get(end)){
            String key = s.substring(end, i);
            genSentence(list, reach, s, pre + key + " ", i);
        }
    }
    /*
    public List<String> wordBreak(String s, List<String> wordDict) {
        int wordMaxLen = Integer.MIN_VALUE;
        for (String word : wordDict){
            wordMaxLen = Math.max(wordMaxLen, word.length());
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        genSentence(list, wordSet, s, "", 0,  wordMaxLen);
        return list;
    }
    private void genSentence(List<String> list, Set<String> wordSet, String s, String pre, int start, int wordMaxLen){
        for (int l = 1, len = s.length(); l <= wordMaxLen && start + l <= len; l++){
            String nowWord = s.substring(start, start + l);
            if (wordSet.contains(nowWord)){
                if (start + l == len) list.add(pre + nowWord);
                else genSentence(list, wordSet, s, pre + nowWord + " ", start + l, wordMaxLen);
            }
        }
    }
    */
}