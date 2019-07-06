class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<>();
        //boolean []flag = new boolean[graph.length];
        dfs(lists, new ArrayList<Integer>(), graph, 0);
        return lists;
    }
    private void dfs(List<List<Integer>> lists, List<Integer> list, int[][] graph, int start){
        list.add(start);
        if (start == graph.length - 1)
            lists.add(new ArrayList<Integer>(list));
        else {
            for (int i = 0; i < graph[start].length; i++){
                dfs(lists, list, graph, graph[start][i]);
            }
        }
        list.remove(list.size() - 1);
    }
}