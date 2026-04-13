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
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval1 = intervals.get(i - 1);
            Interval interval2 = intervals.get(i);

            if (Math.max(interval1.start, interval2.start) < Math.min(interval1.end, interval2.end)) {
                return false;
            }
        }

        return true;
    }
}
