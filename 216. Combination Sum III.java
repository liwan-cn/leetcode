class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> lists = new ArrayList<>();
        if (k > 9 || n > 45) return lists;
        addNext(lists, new ArrayList<Integer>(), k, 1, n);
        return lists;
    }
    private void addNext(List<List<Integer>> lists, List<Integer> list, int k, int start, int n){
        if (list.size() == k && n == 0){
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        if (n < 0) return;
        for (int i = start; i <= 9; i++){
            list.add(i);
            addNext(lists, list, k, i + 1, n - i);
            list.remove(list.size()-1);
        }
    }
}