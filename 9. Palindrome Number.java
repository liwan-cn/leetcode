class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int n = x;
        long sum = 0;
        while (x != 0){
            int s = x % 10;
            sum = sum * 10 + s;
            x = x / 10;
        }
        return sum == n;
        // String s = x + "";
        // return s.equals(new StringBuffer(s).reverse().toString());
    }
}