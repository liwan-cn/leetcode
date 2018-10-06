class Solution {
    private int m, n;
    public int numIslands(char[][] grid) {
        int cnt = 0;
        m = grid.length;
        for(int i = 0; i < m; i ++){
            n = grid[i].length;
            for (int j = 0; j < n; j ++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    cnt ++;
                }
            }
        }
        return cnt;
    }
    private void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}