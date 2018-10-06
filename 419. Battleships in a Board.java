class Solution {
    public int countBattleships(char[][] board) {
        int ret = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                ret += (vaild(board, i, j) ? 1 : 0);
            }
        }
        return ret;
    }
    private boolean vaild(char[][] board, int i, int j){
        if (i == 0 && j == 0) return board[i][j] == 'X';
        if (i == 0) return board[i][j] == 'X' && board[i][j-1] != 'X';
        if (j == 0) return board[i][j] == 'X' && board[i-1][j] != 'X';
        return board[i][j] == 'X' && board[i-1][j] != 'X' && board[i][j-1] != 'X';
    }
}