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
        ListNode dummy = new ListNode(-1, head);
        ListNode KthNode = findKthNode(dummy, k);
        ListNode groupPrev = dummy;
        while (KthNode != null) {
            ListNode groupPrevNext = groupPrev.next;
            ListNode curr = groupPrevNext;
            ListNode prev = KthNode.next;

            while (prev != KthNode) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            groupPrev.next = KthNode;
            groupPrev = groupPrevNext;
            groupPrevNext = groupPrev.next;
            KthNode = findKthNode(groupPrev, k);
        }

        return dummy.next;
    }

    private ListNode findKthNode(ListNode node, int k) {
        if (node == null || k == 0) {
            return node;
        }

        return findKthNode(node.next, k - 1);
    }
}
