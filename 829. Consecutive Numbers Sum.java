class Solution {
    public int consecutiveNumbersSum(int N) {
        //if(N == 1) return 1;
        int res = 0;
        int n = (int) (Math.ceil((Math.sqrt(8*(long)N+1)-1)/2));
        int tmp = 0, num = 0;
        for (int i = n; i >= 1; i--){
            tmp = (i + 1) * i / 2;
            if ((N - tmp) % i == 0) {
                res ++;
            }
        }
        return res;
        /*
        int res = 0;
        for (int i = 1; N > 0; N -= i++)
            if (N % i == 0)
                res ++;
        return res;
        */
    }
}