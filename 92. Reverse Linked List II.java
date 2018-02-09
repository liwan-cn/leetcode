/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode head0 = new ListNode(0);
        head0.next = head;
        ListNode pre = head0;
        for(int i = 0; i < m-1; i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode then = start.next;
        for(int i = 0; i < n-m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return head0.next;
    }
}