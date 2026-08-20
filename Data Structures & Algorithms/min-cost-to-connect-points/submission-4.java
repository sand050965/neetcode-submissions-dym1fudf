class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> visit = new HashSet<>();
        int[] distance = new int[n];
        int result = 0;
        int curr = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (visit.size() < n - 1) {
            int[] point = points[curr];
            int xi = point[0];
            int yi = point[1];
            visit.add(curr);
            int next = -1;

            for (int j = 0; j < n; j++) {
                if (visit.contains(j)) {
                    continue;
                }

                int[] nei = points[j];
                int xj = nei[0];
                int yj = nei[1];
                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);
                distance[j] = Math.min(distance[j], dist);
                if (next == -1 || distance[j] < distance[next]) {
                    next = j;
                }
            }

            result += distance[next];
            curr = next;
        }

        return result;
    }
}
