class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    int cnt = 0;

    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
                dfs(i);
                cnt++;
        }

        return cnt;
    }

    private void dfs(int node) {
        visited.add(node);
        
        for (int nei: adj.get(node)) {
            if (visited.contains(nei)) continue;
            dfs(nei);
        }
    }
}
