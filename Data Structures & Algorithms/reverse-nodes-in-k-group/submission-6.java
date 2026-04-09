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
        ListNode groupPrev = dummy;
        ListNode kthNode = findKthNode(groupPrev, k);
        while (kthNode != null) {
            ListNode groupPrevNext = groupPrev.next;
            ListNode groupNext = kthNode.next;
            ListNode curr = groupPrevNext, prev = groupNext;
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            groupPrev.next = kthNode;
            groupPrev = groupPrevNext;
            kthNode = findKthNode(groupPrev, k);
        }

        return dummy.next;
    }

    private ListNode findKthNode(ListNode curr, int k) {
        while (k > 0 && curr != null) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}
