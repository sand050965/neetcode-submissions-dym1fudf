class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>(), cycle = new HashSet<>();
    int cycleStart = -1;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dfs(1, -1);

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (cycle.contains(u) && cycle.contains(v)) {
                return new int[]{u, v};
            }
        }

        return new int[0];
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) {
            cycleStart = node;
            cycle.add(node);
            return true;
        }

        visited.add(node);
        for (int nei: adj.get(node)) {
            if (nei == parent) continue;

            if (dfs(nei, node)) {
                if (cycleStart != -1) cycle.add(node);
                if (cycleStart == node) {
                    cycleStart = -1;
                }

                return true;
            }
        }

        return false;
    }
}
