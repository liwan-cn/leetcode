class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>(1<<n);
        list.add(0);
        for (int i = 0; i < n; i++){
            int len = list.size();
            for (int j = len-1; j > 0; j++){
                list.add(list.get(j) | (1<<i));
            }
        }
        //for (int i = 0; i < 1<<n; i++) list.add(i ^ i>>1);
        return list;
    }
}