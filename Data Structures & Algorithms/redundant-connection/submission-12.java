class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n + 1];
        Queue<Integer> dq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adj.get(node1).add(node2);
            indegree[node1]++;

            adj.get(node2).add(node1);
            indegree[node2]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 1) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int node = dq.poll();

            for (int nei : adj.get(node)) {
                indegree[nei]--;

                if (indegree[nei] == 1) {
                    dq.offer(nei);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];
            if (indegree[node1] >= 2  && indegree[node2] >= 2) {
                return edge;
            }
        }

        return new int[0];
    }
}
