class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) return lists;
        List<Integer> lastList = new ArrayList<>();
        lastList.add(1);
        lists.add(lastList);
        for (int i = 1; i < numRows; i++){
            List<Integer> nowList = new ArrayList<>();
            nowList.add(1);
            for(int j = 1; j < i; j++){
                nowList.add(lastList.get(j-1) + lastList.get(j));
            }
            nowList.add(1);
            lists.add(nowList);
            lastList = nowList;
        }
        return lists;
    }
}