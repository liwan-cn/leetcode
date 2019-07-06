class Solution {
    public int findLUSlength(String a, String b) {
        int la = a.length(), lb = b.length();
        if (la != lb) return la > lb ? la : lb;
        if (a.equals(b)) return -1;
        return la;
    }
}