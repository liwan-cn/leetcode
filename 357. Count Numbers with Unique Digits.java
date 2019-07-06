class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10, cnt = 9;// 最高位有9种选择,然后是9 8 7 ....
        if (n > 10) n = 10;
        for (int i = 1; i < n; i++){
            cnt *= (10 - i);
            res += cnt;
        }
        return res;
    }
}