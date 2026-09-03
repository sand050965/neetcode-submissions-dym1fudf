class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, result = 0;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        Set<String> visited = new HashSet<>();

        int[] startPoint = points[0];
        minHeap.offer(new int[] {startPoint[0], startPoint[1], 0});

        while (!minHeap.isEmpty() && visited.size() < n) {
            int[] point = minHeap.poll();
            int x = point[0], y = point[1], dist = point[2];
            String key = x + "," + y;

            if (visited.contains(key)) {
                continue;
            }

            visited.add(key);
            result += dist;

            for (int[] nei : points) {
                int neiX = nei[0], neiY = nei[1];
                if (neiX == x && neiY == y) {
                    continue;
                }

                int neiDist = Math.abs(x - neiX) + Math.abs(y - neiY);
                minHeap.offer(new int[] {neiX, neiY, neiDist});
            }
        }

        return result;
    }
}
