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
        if (n == 0) 
            return true;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < n; i++) {
            Interval interval1 = intervals.get(i - 1);
            Interval interval2 = intervals.get(i);
            
            if (interval2.start < interval1.end)
                return false;
        }

        return true;
    }
}
