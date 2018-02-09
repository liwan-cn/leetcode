/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode greatHead = new ListNode(0);
        ListNode list = head, smallTail = smallHead, greatTail = greatHead;
        while (list != null){
            if (list.val < x){
                smallTail.next = list;
                smallTail = smallTail.next;
            } else {
                greatTail.next = list;
                greatTail = greatTail.next;
            }
            list = list.next;
        }
        smallTail.next = null; greatTail.next = null;
        smallTail.next = greatHead.next;
        return smallHead.next;
    }
}