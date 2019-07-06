class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums){
            xor ^= num;
        }
        int flag = 1;
        while ((xor & flag) == 0)  flag <<= 1;
        int first = 0, second = 0;
        for (int num : nums){
            if ((flag & num) == 0) first ^= num;
            else second ^= num;
        }
        return new int[]{first, second};
    }
}