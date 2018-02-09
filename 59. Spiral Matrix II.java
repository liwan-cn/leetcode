class Solution {
    public int[][] generateMatrix(int n)  {
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int cnt = 0;
        int[][] matrix = new int[n][n];
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                matrix[rowBegin][j] = ++cnt;
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                matrix[j][colEnd] = ++cnt;
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    matrix[rowEnd][j] = ++cnt;
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    matrix[j][colBegin] = ++cnt;
                }
            }
            colBegin ++;
        }
        
        return matrix;
    }
}