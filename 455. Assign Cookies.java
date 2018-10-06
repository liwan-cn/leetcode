class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ret = 0;
        for (int i = 0; ret < g.length && i < s.length; i ++){
            if(g[ret] <= s[i]) ret ++;
        }
        return ret;
    }
}