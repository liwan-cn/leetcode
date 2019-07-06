class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0; res < g.length && i < s.length; i ++){
            if(g[res] <= s[i]) res ++;
        }
        return res;
    }
}