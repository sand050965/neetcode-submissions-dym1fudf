class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            int[] prev = (result.isEmpty()) ? null : result.get(result.size() - 1);
            int startTime = interval[0];
            int endTime = interval[1];

            if (result.isEmpty() || Math.max(startTime, prev[0]) > Math.min(endTime, prev[1])) {
                result.add(interval);
            } else {
                prev[0] = Math.min(prev[0], startTime);
                prev[1] = Math.max(prev[1], endTime);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
