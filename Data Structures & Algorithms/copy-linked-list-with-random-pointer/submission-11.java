/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = new Node(-1), curr = head;

        while (curr != null) {
            Node next = curr.next;

            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            Node copy = curr.next, next = copy.next, random = curr.random;
            copy.random = (random == null) ? null : random.next;
            curr = next;
        }

        curr = head;
        dummy.next = curr.next;

        while (curr != null) {
            Node copy = curr.next, next = curr.next.next;
            Node copyNext = (next == null) ? null : next.next;
            curr.next = next;
            copy.next = copyNext;

            curr = next;
        }

        return dummy.next;
    }
}
