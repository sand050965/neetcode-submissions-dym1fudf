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

        while (lists.length > 1) {
            List<ListNode> mergeLists = new ArrayList<>();

            for (int i = 0; i < lists.length; i += 2) {
                ListNode list1 = lists[i];
                ListNode list2 = (i + 1 < lists.length) ? lists[i + 1] : null;
                mergeLists.add(sort(list1, list2));
            }

            lists = mergeLists.toArray(new ListNode[0]);
        }

        return lists[0];
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
