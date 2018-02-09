/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode fast = head, slow = head;
        int len = 0;
        while(fast != null){
            len++;
            fast = fast.next;
        }
        k %= len;
        if(k == 0) return head;
        fast = head;
        int i = 0;
        while(++i <= k) fast = fast.next;
        if(fast == null) return head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}