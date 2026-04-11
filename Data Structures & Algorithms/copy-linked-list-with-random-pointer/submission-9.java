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

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            Node next = curr.next;
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            Node next = copy.next;
            copy.random = (curr.random == null) ? null : curr.random.next;
            curr = next;
        }

        curr = head;
        Node copy = curr.next;
        Node dummy = new Node(-1);
        dummy.next = copy;
        while (curr != null) {
            Node next = copy.next;
            Node copyNext = (next == null) ? null : next.next;

            curr.next = next;
            copy.next = copyNext;

            curr = next;
            copy = copyNext;
        }

        return dummy.next;
    }
}
