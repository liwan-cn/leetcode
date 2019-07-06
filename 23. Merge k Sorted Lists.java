/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>((o1, o2) -> (o1.val - o2.val));
        ListNode head0 = new ListNode(0);
        ListNode tail = head0;
        for (ListNode node : lists)
            if (node != null)
                queue.add(node);
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail  = tail.next;
            if (tail.next != null){
                queue.add(tail.next);
            }
        }
        return head0.next;
    }
}