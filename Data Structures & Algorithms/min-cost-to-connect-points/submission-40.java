class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int result = 0, node = 0;
        Set<Integer> visit = new HashSet<>();
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;

        while (visit.size() < n) {
            result += costs[node];
            visit.add(node);
            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int cost = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                costs[i] = Math.min(costs[i], cost);

                if (nextNode == -1 || costs[i] < costs[nextNode]) {
                    nextNode = i;
                }
            }

            node = nextNode;
        }

        return result;
    }
}
