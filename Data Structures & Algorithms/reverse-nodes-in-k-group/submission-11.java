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
        ListNode dummy = new ListNode(-1, head), prev = dummy;

        while (true) {
            ListNode oldHead = prev.next;
            ListNode oldTail = findKthNode(prev, k);

            if (oldTail == null) {
                break;
            }

            ListNode next = oldTail.next;

            prev.next = reverse(oldHead, next);
            prev = oldHead;
        }

        return dummy.next;
    }

    private ListNode findKthNode(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            if (node == null) {
                break;
            }

            node = node.next;
        }

        return node;
    }

    private ListNode reverse(ListNode head, ListNode tailNext) {
        ListNode curr = head, prev = tailNext;
        while (curr != tailNext) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
