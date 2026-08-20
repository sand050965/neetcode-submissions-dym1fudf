class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) return (n == 1);

        for (int[] edge: edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        return dfs(0, -1) && (visited.size() == n);
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) return false;

        visited.add(node);
        for (int nei: adj.get(node)) {
            if (nei == parent) continue;
            if (!dfs(nei, node)) return false;
        }

        return true;
    }
}
