class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10, tmp = 1, mul = 9;
        if (n > 10) n = 10;
        for (int i = 1; i < n; i++){
            tmp *= mul; mul --;
            //System.out.println(tmp);
            res += 9 * tmp;
        }
        return res;
    }
}