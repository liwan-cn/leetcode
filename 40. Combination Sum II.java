class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        selectNext(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }
    private void selectNext(List<List<Integer>> lists, List<Integer> list, int [] nums, int target, int start){
        if (target < 0) return;
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start, len = nums.length; i < len; i++){
                if(i > start && nums[i] == nums[i-1]) continue;
                list.add(nums[i]);
                selectNext(lists, list, nums, target - nums[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}