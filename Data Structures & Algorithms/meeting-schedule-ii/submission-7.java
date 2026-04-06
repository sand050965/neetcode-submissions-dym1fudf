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

        int result = 0;
        int curr = 0;
        int startIdx = 0;
        int endIdx = 0;
        while (startIdx < n) {
            if (start[startIdx] < end[endIdx]) {
                curr++;
                startIdx++;
            } else {
                curr--;
                endIdx++;
            }

            result = Math.max(result, curr);
        }

        return result;
    }
}
