/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode head0 = new ListNode(0);
        head0 = null;
        ListNode now = head, tail = head0;
        if (now == null || now.next == null) return head;
        if (now.val != now.next.val) {
            tail.next = now;
            tail = tail.next;
        }
        ListNode last = now;
        now = now.next;
        while (now != null){
            if (now.val != last.val){
                if ((now.next != null && now.val != now.next.val) || now.next == null){
                    tail.next = now;
                    tail = tail.next;
                }
            }
            last = now;
            now = now.next;
        }
        return head0.next;
    }
}