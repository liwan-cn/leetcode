class Solution {

    class Node {
        public int value;
        public int listIndex;
        public int valueIndex;
        public Node(int value,int listIndex,int valueIndex){
            this.value = value;
            this.listIndex = listIndex;
            this.valueIndex = valueIndex;

        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.value - o2.value));

        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            pq.offer(new Node(nums.get(i).get(0), i, 0));
            right = Math.max(nums.get(i).get(0), right);
        }
        left = pq.peek().value;

        int []res = new int[]{left, right};

        while (pq.size() == nums.size()) {
            Node tmp = pq.poll();
            if (tmp.valueIndex + 1 < nums.get(tmp.listIndex).size()){
                right = Math.max(nums.get(tmp.listIndex).get(tmp.valueIndex + 1), right);
                tmp.value = nums.get(tmp.listIndex).get(tmp.valueIndex + 1);
                tmp.valueIndex += 1;
                pq.offer(tmp);
                left = pq.peek().value;
                if (right - left < res[1] - res[0]){
                    res[0] = left;
                    res[1] = right;
                }
            }
        }
        return res;
    }
}