class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<int[]> dq = new ArrayDeque<>();
        Set<Integer> visit = new HashSet<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int result = 0;
        int pointIdx = 0;

        while (visit.size() < n) {
            int[] point = points[pointIdx];
            int x = point[0];
            int y = point[1];
            visit.add(pointIdx);
            result += dist[pointIdx];

            int nextPointIdx = -1;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int[] npoint = points[i];
                int nx = npoint[0];
                int ny = npoint[1];
                int ncost = Math.abs(x - nx) + Math.abs(y - ny);
                dist[i] = Math.min(dist[i], ncost);
                if (nextPointIdx == -1 || dist[i] < dist[nextPointIdx]) {
                    nextPointIdx = i;
                }
            }

            pointIdx = nextPointIdx;
        }

        return result;
    }
}
