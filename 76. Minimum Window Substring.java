class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()){
            map[c]++;
        }
        //if c in s map[c] can not > 0
        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int cnt = t.length(), len = s.length();
        while (end < len){
            char ce = s.charAt(end);
            if (map[ce] > 0) cnt--; 
            //if ce in t and map[ce] <= 0, will not influence cnt
            //because the count of ce contained sub (string[s,e]) > contained t
            //if map[ce] <= 0, cnt--, the sub can not be right (cnt==0 , start++)
            map[ce]--;
            end++;
            while(cnt == 0){
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char cs = s.charAt(start);
                map[cs]++;
                if (map[cs] > 0) cnt++;
                start++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}