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

        ListNode secondHead = slow.next, prev = null;
        slow.next = null;

        while (secondHead != null) {
            ListNode next = secondHead.next;
            secondHead.next = prev;
            prev = secondHead;
            secondHead = next;
        }

        ListNode l1 = head;
        ListNode l2 = prev;

        while (l1 != null && l2 != null) {
            ListNode next1 = l1.next, next2 = l2.next;
            l1.next = l2;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }
}
