class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int item : nums){
            max = Math.max(max, item);
            min = Math.min(min, item);
        }
        int gap = (int) Math.ceil((double)(max-min) / (nums.length-1));
        int[] minBound = new int[nums.length-1];
        int[] maxBound = new int[nums.length-1];
        Arrays.fill(minBound, Integer.MAX_VALUE);
        Arrays.fill(maxBound, Integer.MIN_VALUE);
        for (int item : nums){
            if (item == min || item == max)
                continue;
            int idx = (item - min) / gap;
            minBound[idx] = Math.min(item, minBound[idx]);
            maxBound[idx] = Math.max(item, maxBound[idx]);
        }
        int maxGap = 0;
        int pre = min;
        for (int i = 0; i < nums.length-1; i++){
            if (minBound[i] == Integer.MAX_VALUE && maxBound[i] == Integer.MIN_VALUE)
                continue;
            maxGap = Math.max(maxGap, minBound[i] - pre);
            pre = maxBound[i];
            System.out.println(pre);
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
}