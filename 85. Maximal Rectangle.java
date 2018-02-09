class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length ==0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == '1') height[i] = 1;
        }
        int max = largestInLine(height);
        for(int i = 1; i < matrix.length; i ++){
             for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == '1') height[j] += 1;
                else height[j] = 0;
            }
            max = Math.max(max, largestInLine(height));
        }
    
        return max;
    }
    public int largestInLine(int[] heights) {
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