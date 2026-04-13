class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, 
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int prevEnd = Integer.MIN_VALUE;
        int result = 0;

        for (int[] interval : intervals) {
            if (interval[0] < prevEnd) {
                result++;
                prevEnd = Math.min(prevEnd, interval[1]);
            } else {
                prevEnd = interval[1];
            }
        }

        return result;
    }
}
