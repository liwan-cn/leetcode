/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode raw = head, clone = null;
        if (head == null) return null; 
        while (raw != null){
            clone = new RandomListNode(raw.label);
            clone.next = raw.next;
            raw.next = clone;
            raw = clone.next;
        }

        raw = head;
        while (raw != null){
            clone = raw.next;
            if (raw.random == null) clone.random = null;
            else clone.random = raw.random.next;
            raw = raw.next.next;
        }
        raw = head; clone = raw.next;
        RandomListNode node = clone;
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