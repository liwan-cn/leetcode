class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();

        Map<String, List<String>> reach = new HashMap<>();

        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        int strLen = beginWord.length();
        Set<String> visitedSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return res;
        beginSet.add(beginWord);
        endSet.add(endWord);
        visitedSet.add(beginWord);
        visitedSet.add(endWord);
        boolean flag = false;
        boolean flip = true;
        while (!beginSet.isEmpty() && !endSet.isEmpty() && !flag){
            if (beginSet.size() > endSet.size()){
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
                flip = !flip;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet){
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++){
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++){
                        if (c == old) continue;
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            //标志是否找到最短路径, 如果找到, 结束本次循环后就不用继续查找了
                            flag = true;
                        }
                        if ((endSet.contains(target) || !visitedSet.contains(target)) && wordSet.contains(target)) {
                            //endSet包含也要加入  因为要找出路径
                            temp.add(target);
                            String key = flip ? word : target;
                            String val = flip ? target : word;
                            List<String> list = reach.containsKey(key) ? reach.get(key) : new ArrayList<String>();
                            list.add(val);
                            //System.out.println(key + ":" + val);
                            reach.put(key, list);
                        }
                    }
                    chs[i] = old;
                }
            }
            for (String str : temp)// 不同路径到达同一个
                visitedSet.add(str);
            //System.out.println(beginSet);
            //System.out.println(temp);
            beginSet = temp;
        }
        //System.out.println(reach.keySet());
        //System.out.println(reach.values());
        generateList(beginWord, endWord, reach, new ArrayList<String>(Arrays.asList(beginWord)), res);

        return res;
    }
    public void generateList(String start, String end, Map<String, List<String>> reach, List<String> list, List<List<String>> res){
        if (start.equals(end)) {
            res.add(new ArrayList<String>(list));
            return;
        }
        if (!reach.containsKey(start)) return;
        for (String word : reach.get(start)) {
            list.add(word);
            generateList(word, end, reach, list, res);
            list.remove(list.size() - 1);
        }
    }
}