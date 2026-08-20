class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int[][] result = new int[k][2];
        int n = points.length;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;
            maxHeap.offer(new int[]{dist, x, y});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int idx = 0;
        for (int i = 0; i < k; i++) {
            int[] point = maxHeap.poll();
            result[idx++] = new int[]{point[1], point[2]};
        }

        return result;
    }
}
