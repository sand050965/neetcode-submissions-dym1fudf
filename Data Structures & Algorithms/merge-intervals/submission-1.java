class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = null;

        for (int[] interval : intervals) {
            if (prev == null || interval[0] > prev[1]) {
                result.add(interval);
            } else if (interval[0] <= prev[1]) {
                int[] last = result.get(result.size() - 1);
                last[0] = interval[0] = Math.min(last[0], interval[0]);
                last[1] = interval[1] = Math.max(last[1], interval[1]);
            }

            prev = interval;
        }

        return result.toArray(new int[result.size()][0]);
    }
}
