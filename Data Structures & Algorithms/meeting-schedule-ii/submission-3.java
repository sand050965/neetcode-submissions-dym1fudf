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
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            int start = interval.start;
            int end = interval.end;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        int count = 0;
        int result = 0;
        for (Integer key : map.keySet()) {
            count += map.get(key);
            result = Math.max(result, count);
        }

        return result;
    }
}
