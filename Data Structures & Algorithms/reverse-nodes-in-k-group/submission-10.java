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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), prevTail = dummy, newTail = head;

        while (true) {
            ListNode newHead = findKNode(prevTail, k);

            if (newHead == null) {
                break;
            }

            ListNode nextHead = newHead.next;
            prevTail.next = reverse(newTail, newHead);
            newTail.next = nextHead;

            prevTail = newTail;
            newTail = nextHead;
        }

        return dummy.next;
    }

    private ListNode findKNode(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                break;
            }
            
            curr = curr.next;
        }

        return curr;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode curr = head, prev = null;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
