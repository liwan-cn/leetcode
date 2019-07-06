class Solution {
    public int minIncrementForUnique(int[] A) {
        int []map = new int[40000];
        for (int num : A){
            map[num] += 1;
        }
        int res = 0;
        int remain = 0;
        for (int num : map){
            res += remain;
            num += remain;
            remain = num >= 1 ? num - 1 : 0;
        }
        res += ((1 + remain) * remain) >> 1;
        return res;
    }
}