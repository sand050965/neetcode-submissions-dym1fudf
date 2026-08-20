class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] result = new int[k][2];
        for (int[] point : points) {
            int x = point[0], y = point[1];
            int dist = (int) (Math.pow(x, 2) + Math.pow(y, 2));
            minHeap.offer(new int[] {dist, x, y});
        }

        int idx = 0;
        while (k > 0) {
            int[] point = minHeap.poll();
            result[idx++] = new int[]{point[1], point[2]};
            k--;
        }

        return result;
    }
}
