class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        Set<Integer> visited = new HashSet<>();
        int result = 0, n = points.length;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{j, dist});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{i, dist});
            }
        }

        minHeap.offer(new int[]{0, 0});

        while (visited.size() < n) {
            int[] curr = minHeap.poll();
            int node = curr[0], dist = curr[1];
            if (visited.contains(node)) continue;
            result += dist;
            visited.add(node);

            for (int[] nei: adj.getOrDefault(node, Collections.emptyList())) {
                int neiNode = nei[0], neiDist = nei[1];
                if (visited.contains(neiNode)) continue;
                minHeap.offer(nei);
            }
        }

        return result;
    }
}
