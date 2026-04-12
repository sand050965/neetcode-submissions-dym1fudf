class Solution {
    int result = 0;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }

            dfs(i);
            result++;
        }

        return result;
    }

    private void dfs(int node) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        for (int nei : adj.get(node)) {
            if (visited.contains(nei)) {
                continue;
            }

            dfs(nei);
        }
    }
}
