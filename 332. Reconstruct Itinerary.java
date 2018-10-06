class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String[] ticket: tickets){
            map.computeIfAbsent(ticket[0], k->new PriorityQueue<>()).add(ticket[1]);
        }
        dfs(map, res, "JFK");
        Collections.reverse(res);
        return res;
    }
    private void dfs( Map<String, PriorityQueue<String>> map, List<String> res, String from){
        PriorityQueue<String> next = map.get(from);
        while(next != null && !next.isEmpty()){
            dfs(map, res, next.poll());
        }
        res.add(from);
    }
}