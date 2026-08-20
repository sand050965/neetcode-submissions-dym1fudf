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
        if (lists.length == 0) {
            return null;
        }

        return devide(lists, 0, lists.length - 1);
    }

    private ListNode devide(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return lists[l];
        }

        int mid = l + (r - l) / 2;

        ListNode left = devide(lists, l, mid);
        ListNode right = devide(lists, mid + 1, r);
        
        return sort(left, right);
    }

    private ListNode sort(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode l1 = list1, l2 = list2;

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

        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return dummy.next;
    }
}
