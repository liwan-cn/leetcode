class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<List<Integer>> reach = new ArrayList<>();
        List<String> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();

        int len = s.length();
        for (int i = 0; i < len; i++)
            reach.add(new ArrayList<Integer>());
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    reach.get(i-1).add(j);
                }
            }
        }
        System.out.println(reach);
        backtrack(lists, list, reach, s, dp, len);
        return lists;
    }
    public void backtrack(List<String> lists, List<String> list, List<List<Integer>> reach, String s, boolean[] dp, int end){
        if (end == 0) {
            int len = list.size();
            StringBuilder sb = new StringBuilder();
            for (int i = len-1; i >= 0; i--){
                sb.append(list.get(i));
                if (i != 0) 
                    sb.append(" ");
            }
            lists.add(sb.toString());
            return;
        }
        for (int i : reach.get(end-1)){
            String key = s.substring(i, end);
            list.add(key);
            backtrack(lists, list, reach, s, dp, i);
            list.remove(list.size()-1);
        }
    }
}