class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int result = 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visit = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {j, dist});
            }
        }

        minHeap.offer(new int[] {0, 0});

        while (!minHeap.isEmpty() && visit.size() < n) {
            int[] curr = minHeap.poll();
            int point = curr[0], dist = curr[1];
            if (visit.contains(point)) {
                continue;
            }

            result += dist;
            visit.add(point);

            for (int[] nei : adj.getOrDefault(point, new ArrayList<>())) {
                int neiPoint = nei[0], neiDist = nei[1];
                if (visit.contains(neiPoint)) {
                    continue;
                }

                minHeap.offer(new int[] {neiPoint, neiDist});
            }
        }

        return result;
    }
}
