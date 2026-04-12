class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int node = 0;
        int result = 0;
        Set<Integer> visited = new HashSet<>();
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;

        while (visited.size() < n - 1) {
            int[] point = points[node];
            int x = point[0];
            int y = point[1];
            visited.add(node);

            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visited.contains(i)) {
                    continue;
                }

                int[] nPoint = points[i];
                int nx = nPoint[0];
                int ny = nPoint[1];
                int nCost = Math.abs(x - nx) + Math.abs(y - ny);
                costs[i] = Math.min(costs[i], nCost);

                if (nextNode == -1 || costs[i] < costs[nextNode]) {
                    nextNode = i;
                }
            }

            result += costs[nextNode];
            node = nextNode;
        }

        return result;
    }
}
