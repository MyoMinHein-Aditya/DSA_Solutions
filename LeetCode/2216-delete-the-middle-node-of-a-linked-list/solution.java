/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode t = head;
        ListNode r = head.next.next;
        while (r != null && r.next != null) {
            t = t.next;
            r = r.next.next;
        }
        t.next = t.next.next;
        return head;
    }
}
