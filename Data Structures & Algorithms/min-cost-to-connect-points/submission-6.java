class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> visit = new HashSet<>();
        int[] dist = new int[n];
        int result = 0;
        int node = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (visit.size() < n) {
            int[] curr = points[node];
            int x = curr[0];
            int y = curr[1];
            
            visit.add(node);
            result += dist[node];

            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int[] nei = points[i];
                int nx = nei[0];
                int ny = nei[1];
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
