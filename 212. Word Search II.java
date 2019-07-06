class Solution {
    class TrieNode{
        boolean isWord;
        TrieNode []childs;
        public TrieNode() {
            isWord = false;
            childs = new TrieNode[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        //System.out.println(Arrays.toString(words));
        for (String word : words){
            //System.out.println(word);
            TrieNode now = root;
            for (int i = 0, l = word.length(); i < l; i++){
                TrieNode next = now.childs[word.charAt(i) - 'a'];
                if (next == null){
                    next = new TrieNode();
                    now.childs[word.charAt(i) - 'a'] = next;
                }
                if (i == l - 1) next.isWord = true;
                now = next;
            }
        }
        Set<String> res = new HashSet<>();
        boolean [][]flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[i].length; j ++){

                //TrieNode now = root;
                //if (now.childs[word.charAt(i) - 'a'] == null) continue;
                dfs(board, flag, "", root, i, j, res);
            }
        }
        return new ArrayList(res);
    }
    private void dfs(char[][] board, boolean [][]flag, String pre, TrieNode now, int i, int j, Set<String> res){
        //System.out.println(pre + "," + res + ","+ i +"," + j);
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return;
        TrieNode next = now.childs[board[i][j] - 'a'];
        //System.out.println(board[i][j]);
        if (next == null) return;
        if (flag[i][j]) return;
        pre = pre + board[i][j];
        if (next.isWord) res.add(pre);
        flag[i][j] = true;
        dfs(board, flag, pre, next, i + 1, j,  res);
        dfs(board, flag, pre, next, i - 1, j,  res);
        dfs(board, flag, pre, next, i, j + 1,  res);
        dfs(board, flag, pre, next, i, j - 1,  res);
        flag[i][j] = false;
    }
}