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

        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);

        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(dfs(neighbor));
        }

        return clonedNode;
    }

    private Node bfs(Node node) {
        if (node == null) {
            return null;
        }

        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(node);
        Node clone = new Node(node.val);
        map.put(node, clone);

        while (!dq.isEmpty()) {
            Node curr = dq.poll();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    dq.offer(neighbor);
                }
                Node cloneNeighbor = map.getOrDefault(neighbor, new Node(neighbor.val));
                map.putIfAbsent(neighbor, cloneNeighbor);
                map.get(curr).neighbors.add(cloneNeighbor);
            }
        }

        return map.get(node);
    }
}