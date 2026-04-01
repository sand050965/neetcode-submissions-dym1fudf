class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int result = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (prevEnd <= interval[0]) {
                prevEnd = interval[1];
            } else {
                prevEnd = Math.min(prevEnd, interval[1]);
                result++;
            }
        }

        return result;
    }
}
