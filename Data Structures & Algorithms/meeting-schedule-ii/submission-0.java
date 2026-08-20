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
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n], end = new int[n];
        int s = 0, e = 0, result = 0, count = 0;

        for (int i = 0; i < n; i++) {
            Interval interval = intervals.get(i);
            start[i] = interval.start;
            end[i] = interval.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        while (s < n) {
            if (start[s] < end[e]) {
                count++;
                s++;
            } else {
                count--;
                e++;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
