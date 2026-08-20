class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    int result = 0;

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
            if (visit.contains(i)) {
                continue;
            }

            dfs(i, -1);
            result++;
        }

        return result;
    }

    private void dfs(int node, int prev) {
        if (visit.contains(node)) {
            return;
        }

        visit.add(node);

        for (int adjNode : adj.get(node)) {
            if (adjNode == prev) {
                continue;
            }

            dfs(adjNode, node);
        }
    }
}
