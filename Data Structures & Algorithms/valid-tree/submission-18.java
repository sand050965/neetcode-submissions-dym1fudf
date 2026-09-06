class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visitedDfs = new HashSet<>();
    Set<Integer> visitedBfs = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            adj.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        if (!bfs(0, -1)) {
            return false;
        }

        return (visitedBfs.size() == n);
    }

    private boolean dfs(int node, int parent) {
        if (visitedDfs.contains(node)) {
            return false;
        }

        visitedDfs.add(node);

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

    private boolean bfs(int root, int pre) {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {root, pre});
        visitedBfs.add(root);

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int node = curr[0], parent = curr[1];

            for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
                if (nei == parent) {
                    continue;
                }

                if (visitedBfs.contains(nei)) {
                    return false;
                }

                dq.offer(new int[] {nei, node});
                visitedBfs.add(nei);
            }
        }

        return true;
    }
}
