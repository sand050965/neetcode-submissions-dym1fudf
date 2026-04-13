class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] q = new int[n][2];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int query = queries[i];
            q[i] = new int[]{i, query};
        }
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (a[2] == b[2]) ? 
                Integer.compare(a[0], b[0]) : 
                Integer.compare(a[2], b[2])
        );
        Arrays.sort(q, 
            (a, b) -> Integer.compare(a[1], b[1])
        );
        Arrays.sort(intervals, 
            (a, b) -> Integer.compare(a[0], b[0])
        );
        Arrays.fill(result, -1);
        int idx = 0;
        for (int[] query : q) {
            int queryIdx = query[0];
            int queryVal = query[1];
            while (idx < intervals.length && intervals[idx][0] <= queryVal) {
                int[] interval = intervals[idx];
                int start = interval[0];
                int end = interval[1];
                int len = end - start + 1;
                minHeap.offer(new int[] {start, end, len});
                idx++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < queryVal) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                continue;
            }

            result[queryIdx] = minHeap.peek()[2];
        }

        return result;
    }
}
