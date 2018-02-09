class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, high = 0, result = 0;
        while(left < right){
            high = Math.max(high, Math.min(height[left], height[right]));
            if(height[left] < height[right])
                result += high - height[left++];
            else
                result += high - height[right--];
        }
        return result;
    }
}