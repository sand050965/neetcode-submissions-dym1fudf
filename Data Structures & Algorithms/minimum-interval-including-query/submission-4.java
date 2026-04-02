class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int m = intervals.length, n = queries.length;
        int[] result = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int idx = 0;
        for (int query : Arrays.stream(queries).sorted().toArray()) {
            while (idx < m && query >= intervals[idx][0]) {
                int[] interval = intervals[idx];
                int start = interval[0], end = interval[1];
                minHeap.offer(new int[] {end - start + 1, end});
                idx++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            int len = (minHeap.isEmpty()) ? -1 : minHeap.peek()[0];
            map.put(query, len);
        }

        for (int i = 0; i < n; i++) {
            result[i] = map.get(queries[i]);
        }

        return result;
    }
}
