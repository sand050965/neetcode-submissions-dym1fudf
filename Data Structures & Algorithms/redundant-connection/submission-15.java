class Solution {
    int cycleStart = -1;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adj.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
            adj.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
        }

        dfs(1, -1);

        for (int i = n - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];

            if (cycle.contains(node1) && cycle.contains(node2)) {
                return edge;
            }
        }

        return null;
    }

    private boolean dfs(int node, int prev) {
        if (visited.contains(node)) {
            cycleStart = node;
            return false;
        }

        visited.add(node);
        for (int nei : adj.get(node)) {
            if (nei == prev) {
                continue;
            }

            if (!dfs(nei, node)) {
                if (cycleStart != -1) {
                    cycle.add(node);
                }

                if (cycleStart == node) {
                    cycleStart = -1;
                }

                return false;
            }
        }

        return true;
    }
}
