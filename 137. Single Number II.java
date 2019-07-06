class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int c : nums) {
            b = b ^ c & ~ a;
            a = a ^ c & ~ b;
        }
        return b;
        /*
        int one = 0, two = 0, three = 0;
        for (int num : nums){
            // two的相应的位等于1，表示该位出现2次
            two |= one & num;
            // one的相应的位等于1，表示该位出现1次
            one ^= num;
            // three的相应的位等于1，表示该位出现3次
            three = one & two;
            // 如果相应的位出现3次，则该位重置为0
            // one的相应的位等于1，表示该位出现1次
            one &= ~three;
            // two的相应的位等于1，表示该位出现2次
            two &= ~three;
        }
        return one;
        */
    }
}