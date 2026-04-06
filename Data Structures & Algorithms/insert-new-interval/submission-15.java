class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];

            if (newInterval == null || endTime < newInterval[0]) {
                result.add(interval);
            } else if (Math.max(startTime, newInterval[0]) <= Math.min(endTime, newInterval[1])) {
                newInterval[0] = Math.min(newInterval[0], startTime);
                newInterval[1] = Math.max(newInterval[1], endTime);
            } else if (newInterval[1] < startTime) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            }
        }

        if (newInterval != null) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
