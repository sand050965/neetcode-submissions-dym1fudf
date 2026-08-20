class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        int[] prev = null;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {
            if (prev == null || interval[0] >= prev[1]) {
                prev = interval;
            } else if (interval[0] < prev[1]) {
                result++;
                prev[1] = Math.min(prev[1], interval[1]);
            }
        }

        return result;
    }
}
