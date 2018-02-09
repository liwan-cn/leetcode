class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] ret = new int[len+1];
        ret[0] = 1;
        if (s.charAt(0) != '0') ret[1] = 1;
        for (int i = 1; i < len; i++){
            boolean one = false, two = false;
            one = s.charAt(i) != '0';
            int tmp = (s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0';
            two = tmp >= 10 && tmp <= 26;
            if (one) ret[i+1] += ret[i];
            if (two) ret[i+1] += ret[i-1];
            System.out.println(i + ":" + ret[i+1]);
        }
        return ret[len];
    }
}