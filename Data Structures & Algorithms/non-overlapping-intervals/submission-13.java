class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = intervals[0];
        int result = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int startTime = interval[0];
            int endTime = interval[1];
            if (Math.max(startTime, prev[0]) < Math.min(endTime, prev[1])) {
                result++;
                prev = (prev[1] < endTime) ? prev : interval;
                continue;
            }

            prev = interval;
        }

        return result;
    }
}
