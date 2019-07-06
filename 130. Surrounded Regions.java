class Solution {
    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++){
            boundaryDFS(board, i, 0);
            boundaryDFS(board, i, n-1);
        }
        for (int j = 0; j < n; j++){
            boundaryDFS(board, 0, j);
            boundaryDFS(board, m-1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return;
        if (board[i][j] != 'O') return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        boundaryDFS(board, i-1, j);
        boundaryDFS(board, i+1, j);
        boundaryDFS(board, i, j-1);
        boundaryDFS(board, i, j+1);
    }
}