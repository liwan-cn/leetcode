class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 0) return 0;
        int[] res = new int[len+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++){
                res[j] = list.get(j) + Math.min(res[j], res[j+1]);
            }
            //System.out.println(Arrays.toString(res));
        }
        return res[0];
    }
}