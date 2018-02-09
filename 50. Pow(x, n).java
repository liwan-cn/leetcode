class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == Integer.MIN_VALUE)
            return 1 / x * myPow(1 / x , Integer.MAX_VALUE);
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        return (n & 1) == 0 ? myPow(x * x, n >> 1) : x * myPow(x * x, n >> 1);
    }
}