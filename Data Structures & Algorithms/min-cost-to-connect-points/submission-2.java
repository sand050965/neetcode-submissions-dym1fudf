class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<String, List<int[]>> adj = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // [xi, yi, dist]
        Set<String> visit = new HashSet<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            int xi = point[0];
            int yi = point[1];
            String key = xi + "," + yi;

            for (int j = 0; j < n; j++) {
                int[] nei = points[j];

                if (point == nei) {
                    continue;
                }

                int xj = nei[0];
                int yj = nei[1];
                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);

                adj.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[] {xj, yj, dist});
            }
        }

        int[] src = points[0];
        minHeap.offer(new int[] {src[0], src[1], 0});
        while (!minHeap.isEmpty()) {
            int[] point = minHeap.poll();
            int x = point[0];
            int y = point[1];
            int dist = point[2];
            String key = x + "," + y;
            if (visit.contains(key)) {
                continue;
            }

            visit.add(key);
            result += dist;

            for (int[] nei : adj.getOrDefault(key, new ArrayList<>())) {
                int neiX = nei[0];
                int neiY = nei[1];
                int neiDist = nei[2];
                minHeap.offer(new int[] {neiX, neiY, neiDist});
            }
        }

        return result;
    }
}
