/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode fast = tmp, slow = tmp;
        int cnt = 0;
        while(fast.next != null){
            if(cnt++ >= n)
                slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return tmp.next;
    }
}