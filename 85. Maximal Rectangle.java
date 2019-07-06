class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length ==0 || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == '1') heights[j] ++;
                else heights[j] = 0;
            }
            //System.out.println(Arrays.toString(heights));
            res = Math.max(res, largestInLine(heights));
        }
        return res;
    }
    private int largestInLine(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int res = 0, i = 0;
        while (i <= heights.length) {
            int h = i == heights.length ? 0 : heights[i];
            if (s.isEmpty() || h > heights[s.peek()]){
                s.push(i++);
            } else {
                res = Math.max(res, heights[s.pop()] * (s.isEmpty() ? i : i - 1 - s.peek()));
            }
        }
        return res;
    }
}