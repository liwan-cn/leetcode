import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n/2; i++){
            if (num.charAt(0) == '0' && i > 1) return false;
            for (int j = 1; Math.max(i, j) <= n-i-j; j++){
                if (num.charAt(i) == '0' && j > 1) break;
                BigInteger x1 = new BigInteger(num.substring(0, i));
                BigInteger x2 = new BigInteger(num.substring(i, i+j));
                if (isVaild(x1, x2, i+j, num)) return true;
            }
        }
        return false;
    }
    private boolean isVaild(BigInteger x1, BigInteger x2, int start, String num){
        if (start == num.length()) return true;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return  num.startsWith(sum, start) && isVaild(x1, x2, start + sum.length(), num);
    }
}