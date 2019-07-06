class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int count = 0, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while(i >= 0 && s.charAt(i) != ' '){
            count ++; i--;
        }
        return count;
    }
}