class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int[] prev = result.isEmpty() ? null : result.get(result.size() - 1);
            int[] interval = intervals[i];
            if (prev == null || prev[1] < interval[0]) {
                result.add(interval);
                continue;
            }

            prev[0] = Math.min(prev[0], interval[0]);
            prev[1] = Math.max(prev[1], interval[1]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
