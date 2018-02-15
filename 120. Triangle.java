class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) return 0;
        int[] ret = new int[len];
        ret[0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++){
            List<Integer> list = triangle.get(i);
            int l = list.size();
            ret[l-1] = ret[l-2] + list.get(l-1);
            for (int j = l-2; j > 0; j--){
                ret[j] = list.get(j) + Math.min(ret[j-1], ret[j]);
            }
            ret[0] += list.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ret.length; i++)
            min = Math.min(min, ret[i]);
        return min;
    }
}