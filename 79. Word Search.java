class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (vaild(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    public boolean vaild(char[][] board, String word, int start, int row, int col) {
        if (start >= word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (word.charAt(start++) != board[row][col]) return false;
        char c = board[row][col];
        board[row][col] = '#';
        boolean res = (vaild(board, word, start, row-1, col) 
            || vaild(board, word, start, row+1, col) 
            || vaild(board, word, start, row, col-1) 
            || vaild(board, word, start, row, col+1));
        board[row][col] = c;
        return res;

    }
}