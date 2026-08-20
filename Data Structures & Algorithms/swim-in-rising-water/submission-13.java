class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int result = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        minHeap.offer(new int[] {0, 0, grid[0][0]});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int r = curr[0];
            int c = curr[1];
            int t = grid[r][c];

            result = Math.max(result, t);
            grid[r][c] = -1;

            if (r == ROWS - 1 && c == COLS - 1) {
                return result;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] == -1) {
                    continue;
                }

                int nt = grid[nr][nc];
                minHeap.offer(new int[] {nr, nc, nt});
            }
        }

        return result;
    }
}
