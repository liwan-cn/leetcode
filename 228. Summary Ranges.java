class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int s = nums[0], e = nums[0];
        for (int i = 1, len = nums.length; i < len; i++){
            if (nums[i] - e == 1) e++;
            else {
                addNext(res, s, e);
                s = nums[i]; e = nums[i];
            }
        }
        addNext(res, s, e);
        return res;
    }
    private void addNext(List<String> res, int s, int e){
        if (s == e) res.add(String.valueOf(s));
        else res.add(s + "->" + e);
    }
}