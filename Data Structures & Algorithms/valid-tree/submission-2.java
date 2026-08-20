class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) return false;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        dq.offer(new int[]{0, -1});

        while (!dq.isEmpty()) {
            int[] pair = dq.poll();
            int node = pair[0];
            int parent = pair[1];

            if (visited.contains(node)) return false;

            visited.add(node);

            for (int nei: adj.get(node)) {
                if (nei == parent) continue;
                if (visited.contains(nei)) return false;
                dq.offer(new int[]{nei, node});
            }
        }

        return visited.size() == n;
    }
}
