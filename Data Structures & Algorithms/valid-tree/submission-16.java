class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            adj.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        if (!dfs(0, -1)) {
            return false;
        }

        return (visited.size() == n);
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) {
            return true;
        }

        if (cycle.contains(node)) {
            return false;
        }

        cycle.add(node);

        for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, node)) {
                return false;
            }
        }

        cycle.remove(node);
        visited.add(node);

        return true;
    }
}
