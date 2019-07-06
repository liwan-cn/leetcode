class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long l = (long) dividend, r = (long) divisor;
        boolean sign = !(l > 0 ^ r > 0);
        return sign ? longDivide(Math.abs(l), Math.abs(r)) : -longDivide(Math.abs(l), Math.abs(r));
    }
    private int longDivide(long l, long r){
        if(l < r) return 0;
        int i = 0;
        while(r << ++i <= l);
        return (int) ((1 << (i-1)) + longDivide(l - (r << (i-1)), r));
    }
}