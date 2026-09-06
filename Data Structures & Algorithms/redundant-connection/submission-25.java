class Solution {
    int cycleStart = -1;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            adj.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        dfs(1, -1);

        for (int i = n - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int n1 = edge[0], n2 = edge[1];
            if (cycle.contains(n1) && cycle.contains(n2)) {
                return edge;
            }
        }

        return new int[0];
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) {
            cycleStart = node;
            return false;
        }

        visited.add(node);

        for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, node)) {
                if (cycleStart != -1) {
                    cycle.add(node);

                    if (cycleStart == node) {
                        cycleStart = -1;
                    }
                }

                return false;
            }
        }

        return true;
    }
}
