class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int t = time[2];

            adj.get(u).add(new int[] {v, t});
        }

        int result = 0;
        minHeap.offer(new int[] {k - 1, 0});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[0];
            int t = curr[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            result = t;

            for (int[] nei : adj.get(node)) {
                int neiNode = nei[0];
                int neiT = nei[1];

                if (visited.contains(neiNode)) {
                    continue;
                }

                minHeap.offer(new int[] {neiNode, t + neiT});
            }
        }
        
        return (visited.size() == n) ? result : -1;
    }
}
