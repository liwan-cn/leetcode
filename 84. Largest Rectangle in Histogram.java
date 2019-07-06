class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        单调增序列的index; 位于两个index之间的高度肯定都全部大于后一个
        index的对应的高度, 否则就添加进了栈中; 所以以该index(s.pop())的高度为高
        的矩形长度为当前遍历的index(i) - 栈中的下一个index(s.peek()).
        */
        Stack<Integer> s = new Stack<>();
        int res = 0, i = 0;
        while (i <= heights.length) {
            int h = i == heights.length ? 0: heights[i];
            if (s.isEmpty() || h > heights[s.peek()]) {
                s.push(i++);
            } else  {
                res = Math.max(res, heights[s.pop()] * (s.isEmpty() ? i : i - 1 -s.peek()));
            }
        }
        return res;
    }
}