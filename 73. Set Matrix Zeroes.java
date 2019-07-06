class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false,fc = false;
        for (int i = 0, rowLen = matrix.length; i < rowLen; i++){
            for (int j = 0, colLen = matrix[i].length; j < colLen; j++){
                if (matrix[i][j] == 0){
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1, rowLen = matrix.length; i < rowLen; i++){
            for (int j = 1, colLen = matrix[i].length; j < colLen; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr){
            for(int j = 0, colLen = matrix[0].length; j < colLen; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0, rowLen = matrix.length; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}