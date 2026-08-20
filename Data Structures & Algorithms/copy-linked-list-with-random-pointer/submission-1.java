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
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            if (!map.containsKey(curr)) {
                map.put(curr, new Node(curr.val));
            }
            Node copy = map.get(curr);

            if (curr.next != null && !map.containsKey(curr.next)) {
                map.put(curr.next, new Node(curr.next.val));
            }
            copy.next = map.get(curr.next);

            if (curr.random != null && !map.containsKey(curr.random)) {
                map.put(curr.random, new Node(curr.random.val));
            }
            copy.random = map.get(curr.random);
            
            curr = curr.next;
        }

        return map.get(head);
    }
}
