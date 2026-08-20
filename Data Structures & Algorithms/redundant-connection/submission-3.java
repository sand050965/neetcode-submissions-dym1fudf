class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> dq = new ArrayDeque<>();
        int[] indegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        for (int i = 0; i <= n; i++) {
            if (indegree[i] == 1)
                dq.offer(i);
        }

        while (!dq.isEmpty()) {
            int node = dq.poll();
            indegree[node]--;

            for (int nei: adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 1)
                    dq.offer(nei);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];

            if (indegree[u] >= 2 && indegree[v] >= 2)
                return new int[] {u, v};
        }

        return new int[0];
    }
}
