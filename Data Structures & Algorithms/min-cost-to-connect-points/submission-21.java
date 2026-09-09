class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int result = 0, node = 0, edges = 0;
        Set<Integer> visit = new HashSet<>();
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        while (edges < n - 1) {
            visit.add(node);
            int nextNode = -1;

            for (int i = 0; i < n; i++) {
                if (visit.contains(i)) {
                    continue;
                }

                int dist = Math.abs(points[node][0] - points[i][0]) + Math.abs(points[node][1] - points[i][1]);
                arr[i] = Math.min(arr[i], dist);

                if (nextNode == -1 || arr[i] < arr[nextNode]) {
                    nextNode = i;
                }
            }

            result += arr[nextNode];
            node = nextNode;
            edges++;
        }

        return result;
    }
}
