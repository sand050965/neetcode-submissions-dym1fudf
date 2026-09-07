class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    int cycleStart = -1;

    public int[] findRedundantConnection(int[][] edges) {
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            adj.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        dfs(1, -1);

        for (int i = edges.length - 1; i > 0; i--) {
            int[] edge = edges[i];
            int n1 = edge[0], n2 = edge[1];
            if (cycle.contains(n1) && cycle.contains(n2)) {
                return edge;
            }
        }

        return new int[0];
    }

    private boolean dfs(int node, int parent) {
        if (visit.contains(node)) {
            cycleStart = node;
            return false;
        }

        visit.add(node);

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
