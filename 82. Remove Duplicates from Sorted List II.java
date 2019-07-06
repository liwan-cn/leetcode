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
        if (head == null || head.next == null) return head;
        ListNode head0 = new ListNode(0);
        ListNode pre = null, now = head, tail = head0;

        while (now != null) {
            if (valid(now, pre)) {
                tail.next = now;
                tail = tail.next;
            }
            pre = now;
            now = now.next;
        }
        tail.next = null;
        return head0.next;
    }
    private boolean valid(ListNode now, ListNode pre) {
        boolean fp = pre == null || now.val != pre.val;
        boolean fn = now.next == null || now.val != now.next.val;
        return fp && fn;
    }
}