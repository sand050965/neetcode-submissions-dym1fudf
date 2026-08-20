class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0;
        int prevEnd = -1;

        for (int[] interval : intervals) {
            if (prevEnd == -1 || interval[0] >= prevEnd) {
                prevEnd = interval[1];
            } else if (interval[0] < prevEnd) {
                result++;
                prevEnd = Math.min(prevEnd, interval[1]);
            }
        }

        return result;
    }
}
