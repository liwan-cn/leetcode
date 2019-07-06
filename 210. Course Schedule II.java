class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer>[] graph = new HashSet[numCourses];
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int cnt = 0;

        for (int i = 0; i < graph.length; i++){
            graph[i] = new HashSet<Integer>();
        }

        for (int[] edge : prerequisites){

            graph[edge[1]].add(edge[0]);
            indegree[edge[0]] ++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0) {
                queue.add(i);
                res[cnt++] = i;
            }
        }
        while (!queue.isEmpty()){
            for (Integer to : graph[queue.remove()]){
                indegree[to]--;
                if(indegree[to] == 0) {
                    queue.add(to);
                    res[cnt++] = to;
                }
            }
        }
        if (cnt == graph.length) return res;
        return new int[0];
    }
}