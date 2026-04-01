/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < n; i++) {
            Interval prev = intervals.get(i - 1);
            Interval interval = intervals.get(i);

            if (interval.start < prev.end) {
                return false;
            }
        }

        return true;
    }
}
