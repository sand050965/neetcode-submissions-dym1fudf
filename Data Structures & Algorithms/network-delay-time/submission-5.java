class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // [node, time]
        Set<Integer> visit = new HashSet<>();
        int result = 0;

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adj.get(u).add(new int[]{v, t});
        }

        minHeap.offer(new int[] {k, 0});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[0];
            int t = curr[1];

            if (visit.contains(node)) {
                continue;
            }

            visit.add(node);
            result = Math.max(result, t);

            for (int[] nei : adj.get(node)) {
                int neiNode = nei[0];
                int neiT = nei[1];

                minHeap.offer(new int[] {neiNode, t + neiT});
            }
        }

        return (visit.size() == n) ? result : -1;
    }
}
