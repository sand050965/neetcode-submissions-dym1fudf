class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, m = queries.length, i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[m];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while (i < n && intervals[i][0] <= q) {
                int l = intervals[i][0], r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q)
                minHeap.poll();

            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        for (int j = 0; j < m; j++)
            result[j] = map.get(queries[j]);

        return result;
    }
}
