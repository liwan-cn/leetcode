class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        combineK(lists, new ArrayList<Integer>(), 1, n, k);
        return lists;
    }
    private void combineK(List<List<Integer>> lists, List<Integer> list, int start, int n, int k){
        if (k == 0) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        if (n - start + 1 < k) return;
        for (int i = start; i <= n; i++) {
            list.add(i);
            combineK(lists, list, i+1, n, k-1);
            list.remove(list.size()-1);
        }
    }
}