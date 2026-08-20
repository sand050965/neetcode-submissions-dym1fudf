class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // {r, c, t}
        Set<String> visit = new HashSet<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        minHeap.offer(new int[] { 0, 0, grid[0][0] });

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            String key = r + "," + c;

            if (r == n - 1 && c == n - 1) {
                return t;
            }

            if (visit.contains(key)) {
                continue;
            }

            visit.add(key);

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                String nkey = nr + "," + nc;

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visit.contains(nkey)) {
                    continue;
                }

                minHeap.offer(new int[] { nr, nc, Math.max(t, grid[nr][nc]) });
            }
        }

        return n * n;
    }
}
