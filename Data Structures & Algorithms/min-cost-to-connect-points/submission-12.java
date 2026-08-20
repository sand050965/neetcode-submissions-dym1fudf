class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int result = 0;
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        Set<Integer> visited = new HashSet<>();

        int node = 0;
        while(visited.size() < n - 1) {
            int[] point = points[node];
            int x = point[0];
            int y = point[1];
            visited.add(node);

            int nextNode = -1;
            for (int i = 0; i < n; i++) {
                if (visited.contains(i)) {
                    continue;
                }

                int[] neiPoint = points[i];
                int nx = neiPoint[0];
                int ny = neiPoint[1];
                int cost = Math.abs(x - nx) + Math.abs(y - ny);
                costs[i] = Math.min(costs[i], cost);

                if (nextNode == -1 || costs[i] < costs[nextNode]) {
                    nextNode = i;
                }
            }

            node = nextNode;
            result += costs[nextNode];
        }
        
        return result;
    }
}
