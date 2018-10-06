class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int moveBitCnt = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            moveBitCnt++;
        }  
       return m << moveBitCnt;
    }
}