class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int result = 0;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visit = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int[] point1 = points[i];
            int x1 = point1[0], y1 = point1[1];

            for (int j = i + 1; j < n; j++) {
                int[] point2 = points[j];
                int x2 = point2[0], y2 = point2[1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {j, dist});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {i, dist});
            }
        }

        minHeap.offer(new int[] {0, 0});
        while (!minHeap.isEmpty() && visit.size() < n) {
            int[] curr = minHeap.poll();
            int idx = curr[0], dist = curr[1];

            if (visit.contains(idx)) {
                continue;
            }

            visit.add(idx);
            result += dist;

            for (int[] nei : adj.getOrDefault(idx, Collections.emptyList())) {
                int neiIdx = nei[0], neiDist = nei[1];

                if (visit.contains(neiIdx)) {
                    continue;
                }

                minHeap.offer(new int[] {neiIdx, neiDist});
            }
        }

        return result;
    }
}
