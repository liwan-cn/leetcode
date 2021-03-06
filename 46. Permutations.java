class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permuteRemain(lists, nums, 0);
        return lists;
    }
    private void permuteRemain(List<List<Integer>> lists, int[] nums, int start){
        if (start == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            for(int item : nums){
                tmp.add(item);
            }
            lists.add(tmp);
        } else {
            for (int i = start, end = nums.length - 1; i <= end; i++) {
                swap(nums, start, i);
                permuteRemain(lists, nums, start + 1);
                swap(nums, start, i);
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}