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
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            Interval interval = intervals.get(i);
            start[i] = interval.start;
            end[i] = interval.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0, result = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (start[i] < end[j]) {
                i++;
                count++;
            } else if (start[i] >= end[j]) {
                j++;
                count--;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
