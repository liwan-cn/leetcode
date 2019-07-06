/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node levelStart = root;
        while (levelStart != null){
            Node cur = levelStart;
            while (cur != null){
                if (cur.left != null)
                    cur.left.next = cur.right != null ? cur.right : findChildNext(cur.next);
                if (cur.right != null)
                    cur.right.next = findChildNext(cur.next);
                cur = cur.next;
            }
            levelStart = findChildNext(levelStart);
        }
        return root;
    }
    private Node findChildNext(Node start){
        if (start == null) return null;
        if (start.left != null) return start.left;
        if (start.right != null) return start.right;
        return findChildNext(start.next);
    }
}