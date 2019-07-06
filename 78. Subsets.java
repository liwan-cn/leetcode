class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        subsets(lists, new ArrayList<Integer>(), nums, 0);
        return lists;
    }
    private void subsets(List<List<Integer>> lists, List<Integer> list,int[] nums, int start) {
        lists.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(lists, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}