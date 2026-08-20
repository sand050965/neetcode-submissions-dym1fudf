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
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode curr = slow.next;
        ListNode prev = slow.next = null;

        while (curr != null) {
            ListNode oldNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = oldNext;
        }

        ListNode firstHalfCurr = head;
        ListNode secondHalfCurr = prev;
        while (secondHalfCurr != null) {
            ListNode oldFirstNext = firstHalfCurr.next;
            ListNode oldSecondNext = secondHalfCurr.next;

            firstHalfCurr.next = secondHalfCurr;
            secondHalfCurr.next = oldFirstNext;
            firstHalfCurr = oldFirstNext;
            secondHalfCurr = oldSecondNext;
        }
    }
}
