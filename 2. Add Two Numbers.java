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
         return calculate(l1, l2, 0);
    }
    public ListNode calculate(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry==0)
            return null;
        int digit1 = 0, digit2 = 0;
        if(l1 != null) {
            digit1 = l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            digit2 = l2.val;
            l2 = l2.next;
        }
        ListNode re = new ListNode((digit1+digit2+carry) % 10);
        re.next = calculate(l1, l2, (digit1+digit2+carry) / 10);
        return re;
    } 
}