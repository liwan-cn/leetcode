class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 1; i <= num; i++)
            res[i] = res[i >> 1] + (i & 1); //f(i) = f(i/2) + f(lastBit(i))
        return res;
    }
}