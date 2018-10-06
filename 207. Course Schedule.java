class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] graph = new HashSet[numCourses];
        int[] indegree = new int[numCourses];
        int sum = 0;
        
        for (int i = 0; i < graph.length; i++){
            graph[i] = new HashSet<Integer>();
        }
        
        for (int[] edge : prerequisites){

            graph[edge[1]].add(edge[0]);
            indegree[edge[0]] ++;
            sum ++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()){
            for (Integer to : graph[queue.remove()]){
                indegree[to]--; sum--;
                System.out.println(to + ";" + sum);
                if(indegree[to] == 0)
                    queue.add(to);
            }
        }
        return sum == 0;
    }
}