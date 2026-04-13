class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, 
            (a, b) -> Integer.compare(a[0], b[0])
        );

        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            int[] prevInterval = (result.isEmpty()) ? null : result.get(result.size() - 1);
            if (prevInterval == null || prevInterval[1] < interval[0]) {
                result.add(interval);
            } else if (Math.max(prevInterval[0], interval[0]) <= Math.min(prevInterval[1], interval[1])) {
                prevInterval[0] = Math.min(prevInterval[0], interval[0]);
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
