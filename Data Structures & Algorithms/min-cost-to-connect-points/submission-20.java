class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, result = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visit = new HashSet<>();

        minHeap.offer(new int[] {0, 0});
        while (!minHeap.isEmpty() && visit.size() < n) {
            int[] curr = minHeap.poll();
            int idx = curr[0], dist = curr[1];

            if (visit.contains(idx)) {
                continue;
            }

            visit.add(idx);
            result += dist;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int neiDist = Math.abs(points[idx][0] - points[i][0]) + Math.abs(points[idx][1] - points[i][1]);

                minHeap.offer(new int[] {i, neiDist});
            }
        }

        return result;
    }
}
