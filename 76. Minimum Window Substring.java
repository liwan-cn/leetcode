class Solution {
    public String minWindow(String s, String t) {

        int []map = new int[128];
        for (char c : t.toCharArray()){
            map[c] --;
        }
        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        //cnt 表示区间[start, end]内覆盖了多少个t中的字符
        int cnt = 0, ls = s.length(), lt = t.length();
        while (start < ls && end < ls) {
            char ce = s.charAt(end);
            //假设t中有2个'a', 现在的区间中有3个'a', 计数器不加1
            if (map[ce] < 0) cnt++;
            map[ce] ++; end ++;
            while (cnt == lt) {
                if (minLen >  end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char cs = s.charAt(start);
                map[cs] --;
                //减少了一个覆盖
                if (map[cs] < 0) cnt --;
                start ++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}