class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            adj.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        // if (!dfs(0, -1)) {
        //     return false;
        // }

        if (!bfs(0)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);

        for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
            if (nei == parent) {
                continue;
            }

            if (!dfs(nei, node)) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int root) {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {root, -1});
        visited.add(root);

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int node = curr[0], parent = curr[1];

            for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
                if (nei == parent) {
                    continue;
                }

                if (visited.contains(nei)) {
                    return false;
                }

                dq.offer(new int[] {nei, node});
                visited.add(nei);
            }
        }

        return true;
    }
}
