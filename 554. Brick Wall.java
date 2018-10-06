class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, high = wall.size(); i < high; i++){
            int length = 0;
            for (int j = 0, weight = wall.get(i).size(); j < weight - 1; j++){
                length += wall.get(i).get(j);
                map.put(length, map.getOrDefault(length, 0) + 1);
                if (map.get(length) > max) max = map.get(length);
            }
        }
        return wall.size() - max;
    }
}