class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result = 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int[] time : times) {
            int u = time[0], v = time[1], t = time[2];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[] {v, t});
        }

        minHeap.offer(new int[] {k, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int node = curr[0], t = curr[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            result = Math.max(result, t);

            for (int[] nei : adj.getOrDefault(node, new ArrayList<>())) {
                int neiNode = nei[0], neiT = nei[1];
                minHeap.offer(new int[] {neiNode, t + neiT});
            }
        }

        return (visited.size() < n) ? -1 : result;
    }
}
