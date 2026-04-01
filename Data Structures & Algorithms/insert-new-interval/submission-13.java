class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            if (newInterval != null && newInterval[1] < interval[0]) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            } else if (newInterval == null || interval[1] < newInterval[0]) {
                result.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if (newInterval != null) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
