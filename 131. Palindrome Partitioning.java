class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        if (len == 0) return lists;
        for (int i = len-1; i >= 0; i--){
            dp[i][i] = true;
            for (int j = i+1; j < len; j++){
                if (j == i+1) 
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        //System.out.println(dp[0][1]);

         backtrack(lists, new ArrayList<String>(), s, dp, 0, len);
         return lists;
    }
    public void backtrack(List<List<String>> lists, List<String> list, String s, boolean[][] dp, int start, int end){
        if (start == end){
            lists.add(new ArrayList<String>(list));
            return;
        }
        for (int i = start+1; i <= end; i++){
            if (!dp[start][i-1]) continue;
            list.add(s.substring(start, i));
            backtrack(lists, list, s, dp, i, end);
            list.remove(list.size()-1);
        }
    }
}