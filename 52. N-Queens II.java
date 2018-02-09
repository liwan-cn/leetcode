class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        dfs(board, 0);
        return count;
    }
    
    public void dfs(char[][] board, int row) {
        if(row == board.length) {
            count++;
            return;
        }
        
        for(int j = 0; j < board.length; j++) {
            if(validate(board, row, j)) {
                board[row][j] = 'Q';
                dfs(board, row + 1);
                board[row][j] = '.';
            }
        }
    }
    
    public boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || y == j))
                    return false;
            }
        }
        
        return true;
    }
}