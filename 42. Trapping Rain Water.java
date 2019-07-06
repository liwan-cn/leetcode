class Solution {
    public int trap(int[] height) {
        int s = 0, e = height.length-1, high = 0, res = 0;
        while (s < e) {
            high = Math.min(height[s], height[e]);
            if (height[s] <= height[e]) {
                while (height[s] <= high && s < e) res += high - height[s++];
            } else {
                while (height[e] <= high && s < e) res += high - height[e--];
            }
        }
        return res;
    }
}