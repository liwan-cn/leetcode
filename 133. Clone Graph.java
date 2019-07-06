/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }
    private Node clone(Node node, Map<Integer, Node> map){
        if (node == null) return null;
        if (map.containsKey(node.val))
            return map.get(node.val);
        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        map.put(node.val, cloneNode);
        for (Node n : node.neighbors) {
            cloneNode.neighbors.add(clone(n, map));
        }
        return cloneNode;
    }
}