class Solution {
    /*
    (1) if x is larger than all tails, append it, increase the size by 1
    (2) if tails[i-1] < x <= tails[i], update tails[i]
    */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int ret = 0;
        for (int num: nums){
            int s = 0, e = ret;
            while(s != e){
                int m = (s + e) >> 1;
                if (tails[m] < num)
                    s = m + 1;
                else 
                    e = m;
            }
            tails[s] = num;
            if (s == ret) ret++;
        }
        return ret;
    }
}