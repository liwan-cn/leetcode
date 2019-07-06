class Solution {
    public int maxArea(int[] height) {
        int max = Math.min(height[0], height[height.length-1]) * (height.length-1);
        for (int S = 0, E = height.length-1; S < E;) {
            int s = S, e = E;
            if (height[S] < height[E])
                while (S < E && height[s] >= height[S]) S++;
            else if (height[S] > height[E])
                while (S < E && height[e] >= height[E]) E--;
            else {
                while (S < E && height[s] >= height[S]) S++;
                while (S < E && height[e] >= height[E]) E--;
            }
            max = Math.max(max,Math.min(height[S], height[E]) * (E-S));
        }
        return max;
    }
}