class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        while (end < len){
            sum += nums[end];
            while (sum >= s){
                res = Math.min(res, end - start + 1);
                //System.out.println(start + "; " + end + "; "+ sum);
                sum -= nums[start++];
            }
            end ++;
        }
        return (res != Integer.MAX_VALUE) ? res : 0;
    }
}