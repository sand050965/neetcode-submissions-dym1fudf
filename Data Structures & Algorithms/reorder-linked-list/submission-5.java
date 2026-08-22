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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode l1 = head, l2 = reverse(slow.next);
        slow.next = null;

        while (l1 != null && l2 != null) {
            ListNode next1 = l1.next, next2 = l2.next;
            l1.next = l2;
            l2.next = next1;

            l1 = next1;
            l2 = next2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}
