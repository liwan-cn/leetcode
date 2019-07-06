class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 10, len = s.length(); i <= len; i++){
            String key = s.substring(i-10, i);
            int value = map.getOrDefault(key, 0);
            if (value == 1) list.add(key);
            map.put(key, value + 1);
        }
        return list;
    }
}