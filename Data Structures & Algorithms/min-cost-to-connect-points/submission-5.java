class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // [x, y, dist]
        Set<String> visit = new HashSet<>();
        int result = 0;

        int[] startPoint = points[0];
        int startPointX = startPoint[0];
        int startPointY = startPoint[1];
        minHeap.offer(new int[] {startPointX, startPointY, 0});
        while (!minHeap.isEmpty() && visit.size() < n) {
            int[] curr = minHeap.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];
            String key = x + "," + y;

            if (visit.contains(key)) {
                continue;
            }

            visit.add(key);
            result += dist;

            for (int[] point : points) {
                int nx = point[0];
                int ny = point[1];
                int ndist = Math.abs(x - nx) + Math.abs(y - ny);
                minHeap.offer(new int[] {nx, ny, ndist});
            }
        }

        return result;
    }
}
