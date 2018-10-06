class Solution {
    public int jump(int[] nums) {
        /*
        The correctness proof:
        Initially, through first node, we get the first farthest distance. 
        So, for any position in this range, we know the minimum step is 1.
        Then induce: We use the previous farthest distance d1 to get the new distance d2.
        So, any position in d2- d1 can be reached in 1 step from d1. 
        And we know the minimum step to reach d1. So, for d2, we just plus 1. We can get answer for d2.
        */
        int step = 0;
        int lastReach = 0;
        int nowReach = 0;
        for(int i = 0; i < nums.length-1; i++) {
            nowReach = Math.max(nowReach, i+nums[i]);
            if(i == lastReach) {
                step++;
                lastReach = nowReach;
            } 
        }
        return step;
    }
}