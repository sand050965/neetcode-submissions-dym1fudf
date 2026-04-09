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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            n--;
            if (n < 0) {
                slow = slow.next;
            }
        }

        ListNode curr = slow;
        ListNode target = slow.next;
        ListNode next = target.next;
        curr.next = next;
        target.next = null;

        return dummy.next;
    }
}
