class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] copyQueries = queries.clone();
        Arrays.sort(copyQueries);
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> {
                if (Integer.compare(a[0], b[0]) == 0) {
                    return Integer.compare(a[1], b[1]);
                }

                return Integer.compare(a[0], b[0]);
            }
        );

        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        for (int q : copyQueries) {
            while (idx < intervals.length && intervals[idx][0] <= q) {
                int[] interval = intervals[idx];
                int start = interval[0];
                int end = interval[1];
                minHeap.offer(new int[] {end - start + 1, end});
                idx++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            map.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        for (int i = 0; i < queries.length; i++) {
            result[i] = map.get(queries[i]);
        }

        return result;
    }
}
