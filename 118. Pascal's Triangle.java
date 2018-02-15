class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) return lists;
        List<Integer> eachList = new ArrayList<>();
        eachList.add(1);
        lists.add(eachList);
        for (int i = 1; i < numRows; i++){
            List<Integer> nextList = new ArrayList<>();
            nextList.add(1);
            for(int j = 1; j < i; j++){
                nextList.add(eachList.get(j-1) + eachList.get(j));
            }
            nextList.add(1);
            eachList = nextList;
            lists.add(eachList);
        }
        return lists;
    }
}