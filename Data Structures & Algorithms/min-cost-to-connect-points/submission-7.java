class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> visit = new HashSet<>();
        int[] dist = new int[n];
        int node = 0;
        int result = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (visit.size() < n) {
            int[] point = points[node];
            int x = point[0];
            int y = point[1];
            visit.add(node);
            result += dist[node];

            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }
                
                int[] neiPoint = points[i];
                int nx = neiPoint[0];
                int ny = neiPoint[1];
                int ndist = Math.abs(x - nx) + Math.abs(y - ny);
                dist[i] = Math.min(dist[i], ndist);

                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }

            node = nextNode;
        }

        return result;
    }
}
