class Solution {
    public int maxArea(int[] height) {
        int max = Math.min(height[0], height[height.length-1]) * (height.length-1);
        for(int start = 0, end = height.length-1; start < end; ){
            int s = start, e = end;
            if(height[start] < height[end])
                while(start < end && height[s] >= height[start]) start++;
            else if(height[start] > height[end])
                while(start < end && height[e] >= height[end]) end--;
            else{   
                while(start < end && height[s] >= height[start]) start++;
                while(start < end && height[e] >= height[end]) end--;
            }
            max = Math.max(max,Math.min(height[start], height[end]) * (end-start));
        }
        return max;
    }
}