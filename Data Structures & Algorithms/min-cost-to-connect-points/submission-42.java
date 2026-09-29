class Solution {
    public int minCostConnectPoints(int[][] points) {
        int node = 0, n = points.length, result = 0;
        Set<Integer> visit = new HashSet<>();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        while (visit.size() < n) {
            result += distances[node];
            visit.add(node);
            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);

                distances[i] = Math.min(distances[i], dist);
                if (nextNode == -1 || distances[i] < distances[nextNode]) {
                    nextNode = i;
                }
            }

            node = nextNode;
        }

        return result;
    }
}
