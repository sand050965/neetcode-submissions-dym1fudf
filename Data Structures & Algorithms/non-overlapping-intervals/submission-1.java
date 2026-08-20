class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length, result = 0, prevEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            int start = interval[0], end = interval[1];

            if (start >= prevEnd) {
                prevEnd = end;
            } else {
                result++;
                prevEnd = Math.min(prevEnd, end);
            }
        }

        return result;
    }
}
