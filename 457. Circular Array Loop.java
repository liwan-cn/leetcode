class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1) return false;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == 0) continue;
            // slow/fast pointer
            int slow = i, fast = getIndex(nums, i);
            while (nums[fast] * nums[i] > 0 && nums[getIndex(nums, fast)] * nums[i] > 0) {
                if (slow == fast) {
                    // check for loop with only one element
                    if (slow == getIndex(nums, slow)) break;
                    return true;
                }
                slow = getIndex(nums, slow);
                fast = getIndex(nums, getIndex(nums, fast));
            }
            // loop not found, set all element along the way to 0
            slow = i;
            while (nums[slow] * nums[i] > 0) {
                int next = getIndex(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }
        return false;
    }
    private int getIndex(int[] nums, int i) {
        int n = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % n: n + ((i + nums[i]) % n);
    }
}