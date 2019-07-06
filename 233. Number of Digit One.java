class Solution {
    //通用解法 可以计算任何一个数字的出现次数
    public int countDigitOne(int n) {
        int digit = 1, except0 = 1;
        int base = 1, k = 1, t = n;
        while (t >= 10) {
            t /= 10;
            base *= 10;
            k ++;
            except0 += base;
        }
        if (digit == 0) return calculate(n, digit, base, k) - except0;
        return calculate(n, digit, base, k);
    }
    private int calculate(int n, int digit, int base, int k){
        //System.out.println(n+"; "+base+"; "+k);
        if (n < digit) return 0;
        if (n < 10) return 1;
        int first = n / base;
        if (first < digit){
            return 0 + (base / 10 * first * (k - 1)) + calculate(n % base, digit, base / 10, k - 1);
        } else if (first == digit) {
            return (n % base + 1) + (base / 10 * first * (k - 1)) + calculate(n % base, digit, base / 10, k - 1);
        } else {
            return base + (base / 10 * first * (k - 1)) + calculate(n % base, digit, base / 10, k - 1);
        }
    }
}