class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, edges = 0, node = 0, result = 0;
        Set<Integer> visit = new HashSet<>();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (edges < n - 1) {
            visit.add(node);
            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);

                distance[i] = Math.min(distance[i], dist);

                if (nextNode == -1 || distance[i] < distance[nextNode]) {
                    nextNode = i;
                }
            }

            result += distance[nextNode];
            node = nextNode;
            edges++;
        }

        return result;
    }
}
