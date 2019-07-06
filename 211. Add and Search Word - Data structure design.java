class WordDictionary {
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
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String surrfix, TrieNode now){
        if (surrfix.length() == 0){
            return now.isWord;
        }
        char c = surrfix.charAt(0);

        if (c == '.'){
            for (TrieNode node : now.childs){
                if (node != null && search(surrfix.substring(1), node))
                    return true;
            }
        } else {
            TrieNode node = now.childs[c - 'a'];
            if (node != null && search(surrfix.substring(1), node))
                return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */