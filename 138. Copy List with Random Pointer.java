/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node raw = head, clone = null;
        if (head == null) return null;
        //为每一个节点创建一个复制节点, 并插入到其后
        while (raw != null){
            clone = new Node(raw.val, null);
            clone.next = raw.next;
            raw.next = clone;
            raw = clone.next;
        }
        raw = head;
        //所有复制节点的随机指针修正
        while (raw != null){
            clone = raw.next;
            if (raw.random == null) clone.random = null;
            else clone.random = raw.random.next;
            raw = raw.next.next;
        }
        raw = head; clone = raw.next;
        Node node = clone;
        //恢复原始链表并重建新链表
        while (raw != null && clone != null){
            raw.next = clone.next;
            if (clone.next == null)
                break;
            raw = clone.next;
            clone.next = raw.next;
            clone = raw.next;
        }
        return node;
    }
}