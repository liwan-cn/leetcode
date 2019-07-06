class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int bucketCnt = gap == 0 ? 1 : (max-min) / gap + 1;
        int[] leftBound = new int[bucketCnt];
        int[] rightBound = new int[bucketCnt];
        Arrays.fill(leftBound, Integer.MAX_VALUE);
        Arrays.fill(rightBound, Integer.MIN_VALUE);
        for (int num : nums) {
            //if (num == max)  continue;
            int idx = gap == 0 ? 0 : (num - min) / gap;
            leftBound[idx] = Math.min(num, leftBound[idx]);
            rightBound[idx] = Math.max(num, rightBound[idx]);
        }
        int maxGap = 0, pre = min;
        for (int i = 0; i < leftBound.length; i++){
            if (leftBound[i] == Integer.MAX_VALUE && rightBound[i] == Integer.MIN_VALUE)
                continue;
            maxGap = Math.max(maxGap, leftBound[i] - pre);
            pre = rightBound[i];
        }
        //maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
}