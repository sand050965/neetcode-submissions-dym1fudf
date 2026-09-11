class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int result = 0, node = 0;
        Set<Integer> visit = new HashSet<>();
        int[] dists = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            visit.add(node);

            int nextNode = -1;
            for (int j = 0; j < n; j++) {
                if (visit.contains(j)) {
                    continue;
                }

                int dist = Math.abs(points[node][0] - points[j][0]) + Math.abs(points[node][1] - points[j][1]);
                dists[j] = Math.min(dists[j], dist);

                if (nextNode == -1 || dists[j] < dists[nextNode]) {
                    nextNode = j;
                }
            }

            result += dists[nextNode];
            node = nextNode;
        }

        return result;
    }
}
