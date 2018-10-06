class Solution {
    public int titleToNumber(String s) {
        int a = 1, re = 0, l = s.length();
        for(int i = l-1; i >= 0; i--,a *= 26){
            re += (s.charAt(i)-'A'+1) * a;
        }
        return re;
    }
}