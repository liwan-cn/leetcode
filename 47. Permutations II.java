class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, nums, 0, nums.length-1);
        return list;
    }
    public void backtrack(List<List<Integer>> list, int[] nums, int begin, int end) {
        if (begin == end) {
            List<Integer> tmp = new ArrayList<>();
            for(int item : nums){
                tmp.add(item);
            }
            list.add(tmp);
        } else {
            for (int i = begin; i <= end; i++) {
                if (!swapAccepted(nums, begin, i)) continue;
                swap(nums, begin, i);
                backtrack(list, nums, begin + 1, end);
                swap(nums, begin, i); 
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public boolean swapAccepted(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }
}