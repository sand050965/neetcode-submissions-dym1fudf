class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    int result = 0;

    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                bfs(i);
                result++;
            }
        }

        return result;
    }

    private void bfs(int node) {
        Queue<Integer> dq = new ArrayDeque<>();
        dq.offer(node);
        visit.add(node);

        while (!dq.isEmpty()) {
            int curr = dq.poll();

            for (int nei : adj.get(curr)) {
                if (visit.contains(nei)) {
                    continue;
                }

                dq.offer(nei);
                visit.add(nei);
            }
        }
    }
}