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
        ListNode dummy = new ListNode(-1, head), curr = dummy;
        ListNode prevTail = dummy, newTail = curr.next;;

        while (curr != null) {
            ListNode newHead = findKthNode(curr, k);

            if (newHead == null) {
                break;
            }

            ListNode nextHead = newHead.next;
            prevTail.next = reverse(newTail, k);
            newTail.next = nextHead;
            prevTail = newTail;
            curr = newTail;
            newTail = curr.next;
        }

        return dummy.next;
    }

    private ListNode findKthNode(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                return null;
            }
            
            curr = curr.next;
        }

        return curr;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode curr = head, prev = null;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
