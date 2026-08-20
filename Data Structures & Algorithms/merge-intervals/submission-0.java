class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            int start = interval[0], end = interval[1];
            int[] last = result.get(result.size() - 1);

            if (start <= last[1]) {
                last[0] = Math.min(last[0], start);
                last[1] = Math.max(last[1], end);
            } else {
                result.add(interval);
            }
        }

        return result.toArray(new int[0][]);
    }
}
