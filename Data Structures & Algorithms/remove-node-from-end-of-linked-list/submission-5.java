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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy, fast = dummy;
        int cnt = 0;
        dummy.next = head;

        while (fast != null && fast.next != null) {
            if (cnt >= n) {
                slow = slow.next;
            }

            fast = fast.next;
            cnt++;
        }
        
        slow.next = slow.next.next;

        return dummy.next;
    }
}
