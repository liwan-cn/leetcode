class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;
        int len = s.length();
        while (end < len) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) counter++;
            map[c1]++;
            end++;
            while (counter > 0) {
                char c2 = s.charAt(start);
                if (map[c2] > 1) counter--;
                map[c2]--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
        /*
        int first = 0, last = 0, max = 0;
        Set<Character> set = new HashSet<>();
        int len = s.length();
        while(last < len){
            if(!set.contains(s.charAt(last))){
                set.add(s.charAt(last++));
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(first++));
            }
        }
        return max;
        */
    }
}