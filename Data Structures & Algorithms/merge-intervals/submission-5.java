class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] prev = null;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            if (prev == null || prev[1] < interval[0]) {
                result.add(interval);
            } else {
                prev[0] = Math.min(prev[0], interval[0]);
                prev[1] = Math.max(prev[1], interval[1]);
            }

            prev = result.get(result.size() - 1);
        }

        return result.toArray(new int[result.size()][]);
    }
}
