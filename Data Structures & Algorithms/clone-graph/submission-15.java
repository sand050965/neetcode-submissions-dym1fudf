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
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return bfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        map.put(node, new Node(node.val));
        Node copy = map.get(node);

        for (Node nei : node.neighbors) {
            copy.neighbors.add(dfs(nei));
        }

        return map.get(node);
    }

    private Node bfs(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        map.put(root, new Node(root.val));

        while (!dq.isEmpty()) {
            Node node = dq.poll();
            Node copy = map.get(node);

            for (Node nei : node.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    dq.offer(nei);
                }
                copy.neighbors.add(map.get(nei));
            }
        }

        return map.get(root);
    }
}