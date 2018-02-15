class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        int len = 1;
        int strLen = beginWord.length();
        Set<String> visitedSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        //if (beginWord.equals(endWord)) return 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            if (beginSet.size() > endSet.size()){
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet){
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++){
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++){
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visitedSet.contains(target) && wordSet.contains(target)) {
                            temp.add(target);
                            visitedSet.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }
            beginSet = temp;
            ++len;
        }
        return 0;
    }
}