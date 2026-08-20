class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visit = new HashSet<>();
        Queue<int[]> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        dq.offer(new int[] {0, -1});
        visit.add(0);
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int nei : adj.get(node)) {
                if (nei == parent) {
                    continue;
                }

                if (visit.contains(nei)) {
                    return false;
                }

                dq.offer(new int[] {nei, node});
                visit.add(nei);
            }
        }

        return visit.size() == n;
    }
}
