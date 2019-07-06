class Solution {
    public int integerBreak(int n) {
        int []init = new int[]{0, 0, 1, 2, 4, 6, 9};
        int res = 1;
        while (n >= 7) {
            res *= 3;
            n -= 3;
        }
        return res * init[n];
    }
}