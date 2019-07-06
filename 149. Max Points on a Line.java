class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length-1; i++){
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i+1; j < points.length; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0 && y == 0){
                    overlap ++; continue;
                } else if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    boolean sign = x * y > 0;
                    x = Math.abs(x); y = Math.abs(y);
                    int gcd = gcd(x, y);
                    x /= gcd; y /= gcd;
                    if (!sign) y = -y;
                }
                //System.out.println(x + ";"     + y);
                map.putIfAbsent(x, new HashMap<>());
                map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max + overlap + 1);
        }
        return res;
    }
    private int gcd(int m, int n){
        if (n == 0) return m;
        return gcd(n, m % n);
    }
}