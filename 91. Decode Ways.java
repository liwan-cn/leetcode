class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] ret = new int[len+1];
        ret[0] = 1;
        if (s.charAt(0) != '0') ret[1] = 1;
        for (int i = 1; i < len; i++){
            //单独解码
            boolean single = (s.charAt(i) != '0');
            ret[i+1] += single ? ret[i] : 0;
            //和上一位混合解码
            int tmp = (s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0';
            boolean bi = (tmp >= 10 && tmp <= 26);
            ret[i+1] += bi ? ret[i-1] : 0;
        }
        return ret[len];
    }
}