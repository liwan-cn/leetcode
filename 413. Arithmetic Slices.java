class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int []dp = new int[A.length];
        if (A.length <= 2) return 0;
        dp[0] = 0; dp[1] = 0;
        for (int i = 2, l = A.length; i < l; i++){
            if (A[i] - A[i-1] == A[i-1] - A[i-2])
                dp[i] = dp[i-1] + 1;
        }
        int res = 0;
        for (int cnt: dp) res += cnt;
        return res;
    }
}