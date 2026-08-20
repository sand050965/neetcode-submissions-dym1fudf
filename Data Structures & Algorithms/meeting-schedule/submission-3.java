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
        Interval prev = null;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (Interval interval : intervals) {    
            if (prev == null || interval.start >= prev.end) {
                prev = interval;
            } else if (interval.start < prev.end) {
                return false;
            }
        }

        return true;
    }
}
