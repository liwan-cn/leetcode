class Solution {
    public int singleNonDuplicate(int[] nums) {
        return find(nums, 0, nums.length-1);
    }
    private static int find(int []nums, int start, int end){
        int mid = (start + end) >> 1;
        int len = mid - start + 1;
        if (len == 1) return nums[mid];
        if ((len & 1) == 0 ){
            if (nums[mid] == nums[mid-1]){
                System.out.println(mid+1+";"+end);
                return find(nums, mid + 1, end);
            } else {
                System.out.println(start+";"+(mid-1));
                return find(nums, start, mid - 1);
            }
        } else {
            if (nums[mid] == nums[mid-1]){
                System.out.println(start+";"+(mid-2));
                return find(nums, start, mid - 2);
            } else {
                System.out.println(mid+";"+end);
                return find(nums, mid, end);
            }
        }
    }
}