class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int rows = matrix.length, cols = matrix[0].length;
        boolean [][] pacific = new boolean[rows][cols];
        boolean [][] atlantic = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) bfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
        for (int i = 0; i < rows; i++) bfs(matrix, atlantic, i, cols - 1, Integer.MIN_VALUE);
        for (int i = 0; i < cols; i++) bfs(matrix, pacific, 0, i, Integer.MIN_VALUE);
        for (int i = 0; i < cols; i++) bfs(matrix, atlantic, rows - 1, i , Integer.MIN_VALUE);
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> p = new ArrayList<>();
                    p.add(i); p.add(j);
                    res.add(p);
                }
            }
        }
        return res;
    }
    private void bfs(int [][] matrix, boolean[][] flag, int i, int j, int preValue){
        if (i < 0 || j < 0 || i >= flag.length || j >= flag[i].length)
            return;
        if (flag[i][j]) return;
        if (preValue <= matrix[i][j]) {
            flag[i][j] = true;
            bfs( matrix, flag, i-1, j, matrix[i][j]);
            bfs( matrix, flag, i+1, j, matrix[i][j]);
            bfs( matrix, flag, i, j-1, matrix[i][j]);
            bfs( matrix, flag, i, j+1, matrix[i][j]);
        }
    }
}