class Solution {
    public int lengthOfLongestSubstring(String s) {
        int []flag = new int[128];
        int begin = 0, end = 0, res = 0, cnt = 0;
        int l = s.length();
        while (end < l){
            if (flag[s.charAt(end)] == 0){
                flag[s.charAt(end++)] ++;
                res = Math.max(res, ++cnt);
            } else {
                flag[s.charAt(begin++)] --;
                cnt --;
            }
        }
        return res;
    }
}