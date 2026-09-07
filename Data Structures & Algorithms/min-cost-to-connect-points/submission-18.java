class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, result = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visit = new HashSet<>();

        minHeap.offer(new int[] {0, 0});
        while (!minHeap.isEmpty() && visit.size() < n) {
            int[] curr = minHeap.poll();
            int idx = curr[0], dist = curr[1];
            int[] point1 = points[idx];
            int x1 = point1[0], y1 = point1[1];
            if (visit.contains(idx)) {
                continue;
            }
            visit.add(idx);
            result += dist;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int[] point2 = points[i];
                int x2 = point2[0], y2 = point2[1];
                int dist2 = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                minHeap.offer(new int[] {i, dist2});
            }
        }

        return result;
    }
}
