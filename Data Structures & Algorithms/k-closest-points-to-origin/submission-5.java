class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0], y = point[1];
            int dist = x * x + y * y;
            maxHeap.offer(new int[] {i, dist});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[maxHeap.size()][2];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            result[idx++] = points[maxHeap.poll()[0]];
        }

        return result;
    }
}
