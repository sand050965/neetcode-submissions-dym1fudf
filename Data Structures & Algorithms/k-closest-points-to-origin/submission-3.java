class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[2], a[2])
        ); // [xi, yi, dist]
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;
            maxHeap.offer(new int[]{x, y, dist});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[maxHeap.size()][2];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            int x = point[0];
            int y = point[1];
            result[idx++] = new int[] {x, y};
        }

        return result;
    }
}
