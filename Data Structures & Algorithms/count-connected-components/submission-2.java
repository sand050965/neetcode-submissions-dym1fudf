class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> dq = new ArrayDeque<>();
    int cnt = 0;

    public int countComponents(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;
            bfs(i);
            cnt++;
        }

        return cnt;
    }

    private void bfs(int node) {
        dq.offer(node);
        visited.add(node);

        while (!dq.isEmpty()) {
            int curr = dq.poll();

            for (int nei: adj.get(curr)) {
                if (visited.contains(nei)) continue;
                dq.offer(nei);
                visited.add(nei);
            }
        }
    }
}
