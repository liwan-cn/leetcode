class Solution {
    public boolean isSubsequence(String s, String t) {
        int lt = t.length(), ls = s.length();
        if (ls > lt) return false;
        int i = 0;
        for (int j = 0; j < lt && i < ls; j++){
            if (s.charAt(i) == t.charAt(j)) i++;
        }
        if (i >= ls) return true;
        return false;
    }
}