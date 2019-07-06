class Trie {
    class TrieNode{
        boolean isWord;
        TrieNode []childs;
        public TrieNode() {
            isWord = false;
            childs = new TrieNode[26];
        }
    }
    TrieNode root = null;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        if (node == null) return false;
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode now = root;
        for (int i = 0, l = prefix.length(); i < l; i++){
            TrieNode next = now.childs[prefix.charAt(i) - 'a'];
            if (next == null){
                return null;
            }
            now = next;
        }
        return now;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */