class Solution {
    public List<String> findItinerary(String[][] tickets) {
        //很巧妙的方法 保证自然排序 如果一个节点有两种选择
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String[] ticket: tickets){
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
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
        //在最后添加 保证自然排序 先添加了一个走不完的话 下一个就覆盖了
        //比如 a->b, a->c, c->a
        res.add(from);
    }
}