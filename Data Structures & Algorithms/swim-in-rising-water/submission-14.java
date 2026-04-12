class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        int result = grid[0][0];

        minHeap.offer(new int[] {0, 0, grid[0][0]});
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            grid[r][c] = -1;
            result = Math.max(result, t);

            if (r == ROWS - 1 && c == COLS - 1) {
                return result;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] == -1) {
                    continue;
                }

                minHeap.offer(new int[] {nr, nc, grid[nr][nc]});
            }
        }

        return 0;
    }
}
