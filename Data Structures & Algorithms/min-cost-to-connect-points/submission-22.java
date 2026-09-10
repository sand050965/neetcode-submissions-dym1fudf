class Solution {
    public int minCostConnectPoints(int[][] points) {
        int result = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        minHeap.offer(new int[] {0, 0});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currIdx = curr[0], currCost = curr[1];
            int[] point = points[currIdx];

            if (visit.contains(currIdx)) {
                continue;
            }

            result += currCost;
            visit.add(currIdx);

            if (visit.size() == points.length) {
                break;
            }

            for (int i = 0; i < points.length; i++) {
                if (visit.contains(i)) {
                    continue;
                }
                
                int[] neiPoint = points[i];
                int dist = Math.abs(point[0] - neiPoint[0]) + Math.abs(point[1] - neiPoint[1]);
                minHeap.offer(new int[] {i, dist});
            }
        }

        return result;
    }
}
