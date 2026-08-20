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
    //           prev. curr       
    //              groupNext    
    //                 |
    // dummy [3, 2, 1, 4, 5]
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        ListNode groupPrevNext = groupPrev.next;
        ListNode KthNode = findKthNode(dummy, k);

        while (KthNode != null) {
            ListNode groupNext = KthNode.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

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
        if (k == 0 || node == null) {
            return node;
        }

        return findKthNode(node.next, k - 1);
    }
}
