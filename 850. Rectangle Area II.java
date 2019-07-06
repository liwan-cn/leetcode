class Solution {

    private static final int MOD = 1000000007;

    //for solution 1
    class Line{
        int index, flag, start, end;
        Line(int index, int flag, int start, int end){
            this.index = index; this.flag = flag;
            this.start = start; this.end = end;
        }
        @Override
        public String toString(){
            return "{index: " + index + ", flag: " + flag  + ", start: " + start + ", end: " + end + "}";
        }
    }

    //for solution 1
    private List<Integer> generateXs(int [][] rects){
        List<Integer> xs = new ArrayList<>();
        for (int []rect : rects){
            xs.add(rect[0]); xs.add(rect[2]);
        }
        Collections.sort(xs);
        return xs;
    }

    //for solution 1
    private List<Line> generateLines(int [][] rects){
        List<Line> lines = new ArrayList<>();
        for (int[] rect : rects){
            lines.add(new Line(rect[1], 1, rect[0], rect[2]));
            lines.add(new Line(rect[3], -1, rect[0], rect[2]));
        }
        Collections.sort(lines, (o1, o2) -> (o1.index == o2.index ? o1.flag - o2.flag : o1.index - o2.index));
        return lines;
    }

    //for solution 1
    private int getArea(List<Integer> xs, List<Line> lines){
        long res = 0;
        int preX = 0;
        for (int nowX : xs){
            int cnt = 0;
            int lastY = 0;
            if (nowX != preX){
                for (Line line : lines){
                    if (line.start <= preX && line.end >= nowX){
                        if (cnt > 0)
                            res = (res + (long)(nowX - preX) * (long)(line.index - lastY)) % MOD;
                        cnt += line.flag;
                        lastY = line.index;
                    }
                }
                preX = nowX;
            }

        }
        return (int)res;
    }

    //for solution 2
    class Interval{
        int start, end;
        Interval(int start, int end){
            this.start = start; this.end = end;
        }
        @Override
        public String toString(){
            return "{start: " + start + ", end: " + end + "}";
        }
    }

    //for solution 2
    class Node{
        int index;
        boolean isEnd;
        Interval interval;
        Node(int index, boolean isEnd, Interval interval){
            this.index = index; this.isEnd = isEnd;
            this.interval = interval;
        }
    }

    //for solution 2
    private List<Node> generateNodes(int [][] rects){
        List<Node> nodes = new ArrayList<>();
        for (int[] rect : rects){
            Interval interval = new Interval(rect[1], rect[3]);
            nodes.add(new Node(rect[0], false, interval));
            nodes.add(new Node(rect[2], true, interval));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.index - o2.index;
            }
        });
        return nodes;
    }

    //for solution 2
    private int getIntervalsLen(List<Interval> intervals){
        int len = 0;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int preEnd = -1;
        for (Interval now : intervals){
            if (preEnd == -1 || now.start > preEnd){
                len += now.end - now.start;
                preEnd = now.end;
            } else if (now.end > preEnd){
                len += now.end - preEnd;
                preEnd = now.end;
            }
        }
        return len;
    }

    //for solution 2
    private int getArea(List<Node> nodes){
        List<Interval> intervals = new ArrayList<>();
        long res = 0;
        int preX = 0;
        for (Node node : nodes){
            if (preX != node.index) {
                res = (res + (long)getIntervalsLen(intervals) * (long)(node.index - preX)) % MOD;
                preX = node.index;
            }
            if(node.isEnd) intervals.remove(node.interval);
            else intervals.add(node.interval);

        }
        return (int)res;
    }


    public int test1(int [][] rects){
        List<Integer> xs = generateXs(rects);
        List<Line> lines = generateLines(rects);
        // System.out.println(lines);
        return getArea(xs, lines);
    }

    public int test2(int [][] rects){
        List<Node> nodes = generateNodes(rects);
        return getArea(nodes);
    }

    public int rectangleArea(int[][] rectangles) {
        //return test1(rectangles);
        return test2(rectangles);
    }
}