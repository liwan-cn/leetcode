class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        subsets(lists, new ArrayList<>(), nums, 0);
        return lists;
    }
    private void subsets(List<List<Integer>> lists, List<Integer> list,int[] nums, int start) {
        lists.add(new ArrayList<Integer>(list));
        for (int  i = start; i < nums.length; i++) {
            //从某一个之后的都不添加起到选择的作用
            //[1,2,#2#,2,2,3,4], #2#一个分支是添加下一个2, 另一个是跳到3
            if (i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            subsets(lists, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}