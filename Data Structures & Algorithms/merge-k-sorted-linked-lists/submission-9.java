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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int n = lists.length;
        int interval = 1, step = 2;

        while (interval < n) {
            for (int i = 0; i < n; i += step) {
                if (i + interval >= n) {
                    break;
                }

                ListNode l1 = lists[i], l2 = lists[i + interval];
                lists[i] = merge(l1, l2);
            }

            interval *= 2;
            step *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
