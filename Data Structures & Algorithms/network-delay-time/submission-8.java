class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Set<Integer> visit = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        int result = 0;

        for (int i = 1; i <= n; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0], v = time[1], t = time[2];
            adj.get(u).add(new int[]{v, t});
        }

        minHeap.offer(new int[]{k, 0});
        while (!minHeap.isEmpty() && visit.size() < n) {
            int[] curr = minHeap.poll();
            int node = curr[0], time = curr[1];
            visit.add(node);
            result = Math.max(result, time);

            for (int[] nei : adj.get(node)) {
                int neiNode = nei[0], neiTime = nei[1];
                if (visit.contains(neiNode)) {
                    continue;
                }

                minHeap.offer(new int[]{neiNode, time + neiTime});
            }
        }

        return visit.size() != n ? -1 : result;
    }
}
