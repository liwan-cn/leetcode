class Solution {
    public int singleNonDuplicate(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    private int find(int []nums, int start, int end){
        int mid = (start + end) >> 1;
        int len = mid - start + 1;
        if (len == 1) return nums[mid];
        if ((len & 1) == 0 ){
            if (nums[mid] == nums[mid-1]) return find(nums, mid + 1, end);
            else return find(nums, start, mid - 1);
        } else {
            if (nums[mid] == nums[mid-1]) return find(nums, start, mid - 2);
            else return find(nums, mid, end);
        }
    }
}