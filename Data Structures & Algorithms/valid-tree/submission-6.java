class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

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

        return bfs(0, -1) && visit.size() == n;
    }

    private boolean dfs(int node, int prev) {
        if (visit.contains(node)) {
            return false;
        }

        visit.add(node);

        for (int adjNode : adj.get(node)) {
            if (adjNode == prev) {
                continue;
            }

            if (!dfs(adjNode, node)) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int startNode, int startPrev) {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {startNode, startPrev});
        visit.add(startNode);

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int node = curr[0];
            int prev = curr[1];          

            for (int adjNode : adj.get(node)) {
                if (adjNode == prev) {
                    continue;
                }

                if (visit.contains(adjNode)) {
                    return false;
                }

                visit.add(adjNode);
                dq.offer(new int[] {adjNode, node});
            }
        }

        return true;
    }
}
