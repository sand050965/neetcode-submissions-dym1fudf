class Solution {
    int result = 0;
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            adj.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }

            bfs(i, -1);
            result++;
        }

        return (visited.size() < n) ? -1 : result;
    }

    private void dfs(int node, int parent) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
            if (nei == parent) {
                continue;
            }

            dfs(nei, node);
        }
    }

    private void bfs(int root, int pre) {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {root, pre});
        visited.add(root);

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int node = curr[0], parent = curr[1];

            for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
                if (nei == parent || visited.contains(nei)) {
                    continue;
                }

                dq.offer(new int[] {nei, node});
                visited.add(nei);
            }
        }
    }
}
