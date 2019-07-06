class Solution {
    public int findDuplicate(int[] nums) {
        /**
         快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
        /*
        int low = 1, high = nums.length-1;
        while (low < high) {
            int mid = (low + high) >> 1;
            int count = 0;
            for(int num: nums) if (num <= mid) count++;
            if (count > mid) high = mid;
            else low = mid + 1;
        }
        return low;
        */
    }
}