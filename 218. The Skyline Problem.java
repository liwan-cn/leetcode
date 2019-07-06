class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b : buildings) {
            // start point has negative height value
            height.add(new int[]{b[0], b[2]});
            // end point has normal height value
            height.add(new int[]{b[1], -b[2]});
        }
        Collections.sort(height, (a, b) -> a[0] != b[0] ?  a[0] - b[0] : b[1] - a[1]);

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;

        for(int[] h : height) {
            if(h[1] > 0) pq.offer(h[1]); // a start point, add height
            else pq.remove(-h[1]);  // a end point, remove height

            int cur = pq.peek(); // current max height;

            if(prev != cur) {
                result.add(new ArrayList<Integer>(){
                    {add(h[0]); add(cur);}
                });
                prev = cur;
            }
        }
        return result;
    }
}