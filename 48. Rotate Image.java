class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix[0].length; j++){
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
        for(int i = 0, len = matrix.length; i < len; i++){
            for(int j = 0; j < len >> 1; j++){
                matrix[i][j] ^= matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][matrix.length-1-j];
            }
        }
    }
}