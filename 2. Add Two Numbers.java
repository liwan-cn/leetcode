/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        int d1 = 0, d2 = 0;
        if (l1 != null) {
            d1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            d2 = l2.val;
            l2 = l2.next;
        }
        ListNode head = new ListNode((d1 + d2 + carry) % 10);
        head.next = addTwoNumbers(l1, l2, (d1 + d2 + carry) / 10);
        return head;
    }
}