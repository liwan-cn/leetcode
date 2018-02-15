class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int num : nums){
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
        /*
        每次循环
        先计算 twos, 即出现两次及以上的 1 的分布
        计算出现奇数次的 1 的分布
        二者进行与操作得到出现三次的 1 的分布情况
        threes 取反，与 ones 进行与操作，奇数次减去3次, 得到ones
        threes 取反，与 ones 进行与操作，两次及以上减去3次, 得到twos
        */
    }
}