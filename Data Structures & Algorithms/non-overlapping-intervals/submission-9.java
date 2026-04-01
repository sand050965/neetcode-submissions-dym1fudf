class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int result = 0;
        int prev = -1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            if (prev == -1) {
                prev = interval[1];
                continue;
            }

            if (interval[0] < prev) {
                prev = Math.min(prev, interval[1]);
                result++;
                continue;
            }

            prev = interval[1];
        }

        return result;
    }
}
