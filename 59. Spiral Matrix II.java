class Solution {
    public int[][] generateMatrix(int n) {
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int cnt = 0;
        int[][] matrix = new int[n][n];
        while (rowBegin <= rowEnd && colBegin <= colEnd){
            for (int j = colBegin; j <= colEnd; j ++)
                matrix[rowBegin][j] = ++cnt;
            rowBegin ++;
            for (int i = rowBegin; i <= rowEnd; i ++)
                matrix[i][colEnd] = ++cnt;
            colEnd --;
            if (rowBegin <= rowEnd)
                for (int j = colEnd; j >= colBegin; j --)
                    matrix[rowEnd][j] = ++cnt;
            rowEnd--;
            if (colBegin <= colEnd)
                for (int i = rowEnd; i >= rowBegin; i --)
                    matrix[i][colBegin] = ++ cnt;
            colBegin ++;
        }
        return matrix;
    }
}