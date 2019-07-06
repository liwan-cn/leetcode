class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String word : d){
            if (isSubsequence(s, word)) {
                if (word.length() > res.length()) {
                    res = word;
                } else if (word.length() == res.length()){
                    if(word.compareTo(res) < 0)
                        res = word;
                }
            }
        }
        return res;
    }
    private boolean isSubsequence(String s, String d) {
        int ld = d.length(), ls = s.length();
        if (ls < ld) return false;
        int i = 0;
        for (int j = 0; j < ls && i < ld; j++){
            if (d.charAt(i) == s.charAt(j)) i++;
        }
        if (i >= ld) return true;
        return false;
    }
}