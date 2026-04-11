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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headR = slow.next;
        slow.next = null;
        ListNode head2 = reverse(headR);
        merge(head, head2);
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;

            l1.next = l2;
            l2.next = next1;

            l1 = next1;
            l2 = next2;
        }
    }
}
