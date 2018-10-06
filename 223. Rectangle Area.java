class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int raw = (D - B) * (C - A) + (H - F) * (G - E);
        if (E >= C || A >= G || B > H || F > D) 
            return raw;
        int l = Math.max(A, E);
        int r = Math.min(C, G);
        int u = Math.min(D, H);
        int d = Math.max(B, F);
        return raw - (r - l) * (u - d);
    }
}