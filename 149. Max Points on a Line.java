/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++){
            map.clear();
            int overlap = 0, max = 0;
            for (int j = 0; j < points.length; j++){
                if (i != j){
                    int x = points[j].x - points[i].x;
                    int y = points[j].y - points[i].y;
                    if (x == 0 && y == 0){
                        overlap++;
                        continue;
                    }
                    boolean sign = true;
                    if (x != 0 && y != 0){
                        if (x < 0) sign = !sign;
                        if (y < 0) sign = !sign;
                        x = Math.abs(x); y = Math.abs(y);
                        int gcd = gcd(x, y);
                        x /= gcd; y /= gcd;
                        if (!sign) y = -y;
                    }
                    if (x == 0) y = 1;
                    if (y == 0) x = 1;
                    System.out.println(x + ";" + y);
                    if (map.containsKey(x)){
                        if (map.get(x).containsKey(y)){
                            map.get(x).put(y, map.get(x).get(y)+1);
                        } else {
                            map.get(x).put(y, 1);
                        }
                    } else {
                            Map<Integer, Integer> m = new HashMap<>();
                            m.put(y, 1);
                            map.put(x, m);
                    }
                    max = Math.max(max, map.get(x).get(y));
                }
            }
            res = Math.max(res, max + overlap + 1);
        }
        return res;
    }
    public int gcd(int m, int n){
        if (n == 0) return m;
        return gcd(n, m % n);
    }
}