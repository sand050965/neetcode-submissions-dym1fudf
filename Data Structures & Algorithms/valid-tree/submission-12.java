class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        if (!dfs(0, -1)) {
            return false;
        }

        return (visited.size() == n);
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, node)) {
                return false;
            }
        }

        return true;
    }
}
