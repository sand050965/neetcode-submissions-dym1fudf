class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // [idx, dist]
        Set<Integer> visit = new HashSet<>();
        int cost = 0;

        for (int i = 0; i < n; i++) {
            int[] src = points[i];
            int xi = src[0];
            int yi = src[1];

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int[] target = points[j];
                int xj = target[0];
                int yj = target[1];
                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);

                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{j, dist});
            }
        }

        minHeap.offer(new int[] {0, 0});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int idx = curr[0];
            int dist = curr[1];

            if (visit.contains(idx)) {
                continue;
            }

            cost += dist;
            visit.add(idx);

            for (int[] nei : adj.getOrDefault(idx, new ArrayList<>())) {
                minHeap.offer(nei);
            }
        }

        return cost;
    }
}
