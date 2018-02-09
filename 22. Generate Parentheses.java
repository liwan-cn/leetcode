class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    public void backtrack(List<String> list, String pre, int left, int right, int n){
        if(pre.length() == n << 1){
            list.add(pre);
            return;
        }
        
        if(left < n)
            backtrack(list, pre+"(", left+1, right, n);
        if(right < left)
            backtrack(list, pre+")", left, right+1, n);
    }
}