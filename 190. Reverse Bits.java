public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = (n >> i) & 1;
            result = (result << 1) | temp;
        }
        return result;
    }
}