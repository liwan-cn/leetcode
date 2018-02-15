class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> eachList = new ArrayList<>();
        //if (rowIndex == 0) return eachList;
        eachList.add(1);
        for (int i = 1; i <= rowIndex; i++){
            List<Integer> nextList = new ArrayList<>();
            nextList.add(1);
            for(int j = 1; j < i; j++){
                nextList.add(eachList.get(j-1) + eachList.get(j));
            }
            nextList.add(1);
            eachList = nextList;
        }
        return eachList;
    }
}