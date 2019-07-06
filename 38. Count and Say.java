class Solution {
    public String countAndSay(int n) {
        StringBuilder last = new StringBuilder("1"), now = new StringBuilder();
        while (--n > 0){
            now = new StringBuilder();
            char c = last.charAt(0);
            int cnt = 1;
            for (int j = 1, len = last.length(); j < len; j++){
                if (last.charAt(j) == c){
                    cnt ++;
                } else {
                    now.append(cnt).append(c);
                    c = last.charAt(j);
                    cnt = 1;
                }
            }
            now.append(cnt).append(c);
            last = now;
        }
        return last.toString();
    }
}