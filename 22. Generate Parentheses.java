class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        addNext(list, "", 0, 0, n);
        return list;
    }
    private void addNext(List<String> list, String pre, int left, int right, int n){
        if(left == n && right == n){
            list.add(pre);
            return;
        }
        if (left < n)
            addNext(list, pre + "(", left + 1, right, n);
        if (right < left)
            addNext(list, pre + ")", left, right + 1, n);
    }
}