class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int result = 0;
        int node = 0;
        Set<Integer> visit = new HashSet<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (visit.size() < n) {
            int[] point = points[node];
            int x = point[0];
            int y = point[1];
            result += dist[node];
            visit.add(node);

            int nextNode = -1;
            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int[] npoint = points[i];
                int nx = npoint[0];
                int ny = npoint[1];
                int ncost = Math.abs(x - nx) + Math.abs(y - ny);
                dist[i] = Math.min(dist[i], ncost);

                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }

            node = nextNode;
        }

        return result;
    }
}
