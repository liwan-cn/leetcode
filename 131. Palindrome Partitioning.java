class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        int len = s.length();
        if (len == 0) return lists;
        boolean[][] dp = new boolean[len][len];;
        for (int i = 0; i < len; i++){
            for (int j = i; j >= 0; j--){
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
            }
        }
        generateList(lists, new ArrayList<String>(), s, dp, 0, len);
        return lists;
    }
    private void generateList(List<List<String>> lists, List<String> list,  String s, boolean[][] dp, int start, int end){
        if (start == end){
            lists.add(new ArrayList<String>(list));
            return;
        }
        for (int i = start+1; i <= end; i++){
            if (!dp[start][i-1]) continue;
            list.add(s.substring(start, i));
            generateList(lists, list, s, dp, i, end);
            list.remove(list.size()-1);
        }
    }
}