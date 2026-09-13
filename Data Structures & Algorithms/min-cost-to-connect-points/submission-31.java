class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int result = 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visit = new HashSet<>();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

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
            int pointIdx = curr[0], pointDist = curr[1];
            if (visit.contains(pointIdx)) {
                continue;
            }

            visit.add(pointIdx);
            result += pointDist;

            for (int[] nei : adj.getOrDefault(pointIdx, new ArrayList<>())) {
                int neiPointIdx = nei[0], neiPointDist = nei[1];

                if (visit.contains(neiPointIdx)) {
                    continue;
                }

                minHeap.offer(new int[] {neiPointIdx, neiPointDist});
            }
        }

        return result;
    }
}
