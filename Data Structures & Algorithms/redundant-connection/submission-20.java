class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n + 1];
        Queue<Integer> dq = new ArrayDeque<>();

        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            adj.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
            indegree[n1]++;
            indegree[n2]++;
        }

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 1) {
                dq.offer(i);
            }
        }

        while (!dq.isEmpty()) {
            int node = dq.poll();
            indegree[node]--;

            for (int nei : adj.getOrDefault(node, new ArrayList<>())) {
                indegree[nei]--;
                if (indegree[nei] == 1) {
                    dq.offer(nei);
                }
            }
        }
        

        for (int i = n - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int n1 = edge[0], n2 = edge[1];

            if (indegree[n1] == 2 && indegree[n2] == 2) {
                return edge;
            }
        }

        return new int[0];
    }
}
