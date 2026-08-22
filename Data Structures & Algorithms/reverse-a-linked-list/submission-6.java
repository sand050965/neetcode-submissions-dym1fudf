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
    public ListNode reverseList(ListNode head) {
        return dfs(head, null);
    }

    private ListNode dfs(ListNode curr, ListNode prev) {
        if (curr == null) {
            return null;
        }

        if (curr.next == null) {
            curr.next = prev;
            return curr;
        }

        ListNode next = curr.next;
        curr.next = prev;

        return dfs(next, curr);
    }
}
