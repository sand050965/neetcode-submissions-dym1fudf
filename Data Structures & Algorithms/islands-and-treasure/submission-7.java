class Solution {
    int ROWS;
    int COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> dq = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    dq.offer(new int[] {r, c});
                }

            }
        }

        while (!dq.isEmpty()) {
            for (int i = dq.size(); i > 0; i--) {
                int[] curr = dq.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] != Integer.MAX_VALUE) {
                        continue;
                    }

                    dq.offer(new int[] {nr, nc});
                    grid[nr][nc] = grid[r][c] + 1;
                }
            }
        }
    }
}
