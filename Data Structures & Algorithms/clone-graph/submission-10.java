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
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copyNode = new Node(node.val);
        map.put(node, copyNode);

        for (Node nei : node.neighbors) {
            copyNode.neighbors.add(dfs(nei));
        }

        return map.get(node);
    }

    private Node bfs(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> dq = new ArrayDeque<>();
        dq.offer(node);
        map.put(node, new Node(node.val));

        while (!dq.isEmpty()) {
            Node curr = dq.poll();
            Node copyNode = map.get(curr);

            for (Node nei : curr.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    dq.offer(nei);
                }

                copyNode.neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }
}