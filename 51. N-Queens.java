class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    public void dfs(char[][] board, int row, List<List<String>> res) {
        if(row == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int j = 0; j < board.length; j++) {
            if(validate(board, row, j)) {
                board[row][j] = 'Q';
                dfs(board, row + 1, res);
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
    
    public List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}