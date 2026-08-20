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

// brute force:
// use a map to store each node in the original linked list
// make a copy, map the original node to the copied node
// O(N)
// O(N)

// improve1:
// 1. create a copy node
// 2. store the copy node in the original node's random pointer
// 3. for the original random node, we store them in the copy node's random 
// 4. iterate the original linked list and modify the pointer for the copy node
// copy = orignal node.random
// O(N)
// O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = new Node(-1);
        Node currOri = head;
        while (currOri != null) {
            Node random = currOri.random;
            Node copy = new Node(currOri.val);
            currOri.random = copy;
            copy.random = random;

            currOri = currOri.next;
        }

        currOri = head;
        dummy.next = head.random;
        while (currOri != null) {
            Node currCopy = currOri.random;
            currCopy.next = (currOri.next != null) ? currOri.next.random : null;
            currCopy.random = (currCopy.random != null) ? currCopy.random.random : null;

            currOri = currOri.next;
        }

        currOri = head;
        while (currOri != null) {
            currOri.random = null;
            currOri = currOri.next;
        }

        return dummy.next;
    }
}
