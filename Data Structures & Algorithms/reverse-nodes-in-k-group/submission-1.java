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
        ListNode curr = head;
        int cnt = 0;
        while (curr != null && cnt < k) {
            curr = curr.next;
            cnt++;
        }


        if (cnt == k) {
            ListNode prev = reverseKGroup(curr, k);
            curr = head;

            while (cnt > 0) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                cnt--;
            }

            head = prev;
        }

        return head;
    }
}
