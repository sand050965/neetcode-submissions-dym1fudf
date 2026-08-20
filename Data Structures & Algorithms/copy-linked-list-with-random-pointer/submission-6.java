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
            Node random = curr.random;
            
            curr.random = copy;
            copy.random = random;

            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = curr.random;
            copy.next = (curr.next == null) ? null : curr.next.random;
            copy.random = (copy.random == null) ? null : copy.random.random;

            curr = curr.next;
        }

        Node dummy = new Node(-1);
        dummy.next = head.random;
        curr = head;
        while (curr != null) {
            curr.random = null;

            curr = curr.next;
        }

        return dummy.next;
    }
}
