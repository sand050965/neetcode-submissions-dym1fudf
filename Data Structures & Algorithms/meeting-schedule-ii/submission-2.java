/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = encountd;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            Interval interval = intervals.get(i);
            start[i] = interval.start;
            end[i] = interval.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0;
        int count = 0, result = 0;
        while (s < n) {
            if (start[s] < end[e]) {
                count++;
                s++;
            } else if (start[s] >= end[e]) {
                count--;
                e++;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
