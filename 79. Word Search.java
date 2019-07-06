class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (vaild(board, word, 0, i, j))
                    return true;
        return false;
    }
    private boolean vaild(char[][]board, String word, int start, int i, int j){
        if (start >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;
        if (word.charAt(start++) != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '#';
        boolean res = (vaild(board, word, start, i-1, j)
                || vaild(board, word, start, i+1, j)
                || vaild(board, word, start, i, j-1)
                || vaild(board, word, start, i, j+1));
        board[i][j] = c;
        return res;
    }
}