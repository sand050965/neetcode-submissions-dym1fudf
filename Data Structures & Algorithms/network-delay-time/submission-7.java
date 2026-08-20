class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); //[node, time]
        Set<Integer> visit = new HashSet<>();
        int result = 0;

        for (int i = 1; i <= n; i++) {
            adj.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int src = time[0];
            int target = time[1];
            int t = time[2];

            adj.get(src).add(new int[] {target, t});
        }

        minHeap.offer(new int[] {k, 0});

        while (!minHeap.isEmpty() && visit.size() < n) {
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

                if (visit.contains(nei)) {
                    continue;
                }

                minHeap.offer(new int[] {neiNode, t + neiT});
            }
        }
        

        return (visit.size() == n) ? result : -1;
    }
}
