class Solution {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[][] ret = new int[tlen+1][slen+1];
        for (int i = 0; i <= slen; i++)
            ret[0][i] = 1;
        for (int i = 0; i < tlen; i++){
            for (int j = 0; j < slen; j++){
                if (s.charAt(j) == t.charAt(i)){ //tail equal + tail not equal
                    ret[i+1][j+1] = ret[i][j] + ret[i+1][j];
                } else { //tail not equal
                    ret[i+1][j+1] = ret[i+1][j];
                }
            }
        }
        return ret[tlen][slen];
    }
}