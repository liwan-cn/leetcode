class Solution {
    public int addDigits(int num) {
        //X = 100*a + 10*b + c = 99*a + 9*b + (a+b+c)；
        return 1 + (num - 1) % 9;
    }
}