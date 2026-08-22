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
            Node next = curr.next, copy = new Node(curr.val);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        curr = head;
        Node copyHead = curr.next;
        while (curr != null) {
            Node copy = curr.next, next = copy.next;
            Node random = curr.random, copyRandom = (random == null) ? null : random.next;
            copy.random = copyRandom;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            Node copy = curr.next, next = copy.next;
            Node copyNext = (next == null) ? null : next.next;
            curr.next = next;
            copy.next = copyNext;

            curr = next;
        }

        return copyHead;
    }
}
