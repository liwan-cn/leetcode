class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int i = 3, last = 1, res = 2;
        while(i <= n){
            res += last;
            last = res - last;
            i++;
        }
        return res;
    }
}