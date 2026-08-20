class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    int cycleStart = -1;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
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

        return new int[0];
    }

    private boolean dfs(int node, int prev) {
        if (visit.contains(node)) {
            cycleStart = node;
            return false;
        }

        visit.add(node);

        for (int nei : adj.get(node)) {
            if (nei == prev) {
                continue;
            }

            if (dfs(nei, node)) {
                continue;
            }

            if (cycleStart != -1) {
                cycle.add(node);
            }

            if (cycleStart == node) {
                cycleStart = -1;
            }

            return false;
        }

        return true;
    }
}
