class Solution {
    public int titleToNumber(String s) {
        int base = 1, re = 0, l = s.length();
        for(int i = l-1; i >= 0; i--,base *= 26){
            re += (s.charAt(i) - 'A' + 1) * base;
        }
        return re;
    }
}