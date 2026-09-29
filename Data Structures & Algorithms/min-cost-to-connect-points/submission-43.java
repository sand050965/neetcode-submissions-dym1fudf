class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int node = 0, result = 0;
        Set<Integer> visit = new HashSet<>();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[node] = 0;

        while (visit.size() < n) {
            int nextNode = -1;
            result += distances[node];
            visit.add(node);

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
