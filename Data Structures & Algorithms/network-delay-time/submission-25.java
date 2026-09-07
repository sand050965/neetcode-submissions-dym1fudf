class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result = 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visit = new HashSet<>();

        for (int[] time : times) {
            int u = time[0], v = time[1], t = time[2];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[] {v, t});
        }

        minHeap.offer(new int[] {k, 0});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[0], t = curr[1];
            if (visit.contains(node)) {
                continue;
            }

            visit.add(node);
            result = t;

            for (int[] nei : adj.getOrDefault(node, Collections.emptyList())) {
                int neiNode = nei[0], neiT = nei[1];
                minHeap.offer(new int[] {neiNode, t + neiT});
            }
        }

        return (visit.size() == n) ? result : -1;
    }
}
