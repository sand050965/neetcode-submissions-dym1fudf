class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || interval[1] < newInterval[0]) {
                result.add(interval);
            } else if (newInterval[1] < interval[0]) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            } else if (Math.max(interval[0], newInterval[0]) <= Math.min(interval[1], newInterval[1])) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        if (newInterval != null) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
