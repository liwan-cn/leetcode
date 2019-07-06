class Solution {
    class Cell{
        int x, y, h;
        Cell(int x, int y, int h){
            this.x = x; this.y = y; this.h = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        if (n <= 1) return 0;
        int m = heightMap[0].length;
        if (m <= 1) return 0;
        boolean [][]visted = new boolean[n][m];
        PriorityQueue<Cell> queue = new PriorityQueue<>((o1, o2) -> (o1.h - o2.h));
        for (int i = 0; i < n; i++){
            visted[i][0] = true;
            visted[i][m-1] = true;
            queue.offer(new Cell(i, 0, heightMap[i][0]));
            queue.offer(new Cell(i, m-1, heightMap[i][m-1]));
        }
        for (int j = 1; j < m-1; j++){
            visted[0][j] = true;
            visted[n-1][j] = true;
            queue.offer(new Cell(0, j, heightMap[0][j]));
            queue.offer(new Cell(n-1, j, heightMap[n-1][j]));
        }
        int res = 0;
        int [][]ds = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()){
            Cell now = queue.poll();
            for (int []d : ds){
                int x = now.x + d[0];
                int y = now.y + d[1];
                if (x >= 0 && y >= 0 && x < n && y < m && !visted[x][y]){
                    res += Math.max(0, now.h - heightMap[x][y]);
                    queue.add(new Cell(x, y, Math.max(now.h, heightMap[x][y])));
                    visted[x][y] = true;
                }
            }
        }
        return res;

    }
}