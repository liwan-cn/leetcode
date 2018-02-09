class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[end]) {
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[end]){
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                end--;
            }
        }
        return nums[start] == target;
    }
}