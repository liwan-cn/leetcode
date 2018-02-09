class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        subsets(lists, new ArrayList<>(), nums, 0);
        return lists;
    }
    public void subsets(List<List<Integer>> lists, List<Integer> list,int[] nums, int start) {
        lists.add(new ArrayList<Integer>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            subsets(lists, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}