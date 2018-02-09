class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int max = 0, i = 0;
        while (i <= heights.length){
            int h = (i == heights.length ? 0 : heights[i]);
            if (s.isEmpty() || h >=  heights[s.peek()]){
                s.push(i++);
            } else {
                // tp: min height , i right first lower than tp, peek(): right first lower than tp
                int tp = s.pop();
                max = Math.max(max, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
            }
        }
        return max;
    }
}