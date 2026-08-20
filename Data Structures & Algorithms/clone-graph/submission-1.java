/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node cloned = new Node(node.val);
        dfs(node, cloned);

        return cloned;
    }

    private void dfs(Node currNode, Node currClone) {
        if (map.containsKey(currNode.val)) {
            return;
        }

        map.put(currNode.val, currClone);
        for (Node neighbor : currNode.neighbors) {
            Node clonedNeighbor = map.getOrDefault(neighbor.val, new Node(neighbor.val));
            currClone.neighbors.add(clonedNeighbor);
            dfs(neighbor, clonedNeighbor);
        }
    }
}