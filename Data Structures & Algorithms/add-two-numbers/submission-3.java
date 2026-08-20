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

// ListNode l1
        // ListNode l2

        // l1 = 123 => 3 -> 2 -> 1
        // l2 = 4967 => 7 -> 6 -> 9 -> 4
        // sum = 5090 => 0 -> 9 -> 0 -> 5

        // l1 = 9
        // l2 = 2
        // output = 11 => 1 -> 1

        // brute force:
        // 1. get number val in both linkedlists
        // 2. reverse the numbers, and add 2 numbers to get the sum
        // 3. reverse the sum, and build the result linked list
        // O(M + N)
        // O(M + N)

        // improve:
        // 1. iterate the 2 lists together to add the digits and get the sum val
        // 2. if the sum val has a carry or not
        // 3. keep track of the carry
        // 4. add the 2 digits + carry
        // 5. keep repeating until one of the linked list reach the end
        // O(min(M, N))
        // O(1)

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            curr.next = new ListNode(digit);

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            curr = curr.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
