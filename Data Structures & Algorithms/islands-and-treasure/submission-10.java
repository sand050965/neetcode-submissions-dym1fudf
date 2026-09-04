class Solution {
    int ROWS, COLS;
    int INF = 2147483647;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int level = 1;
        Queue<int[]> dq = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != 0) {
                    continue;
                }

                dq.offer(new int[] {r, c});
            }
        }

        while (!dq.isEmpty()) {
            for (int i = dq.size(); i > 0; i--) {
                int[] curr = dq.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] != INF) {
                        continue;
                    }

                    dq.offer(new int[] {nr, nc});
                    grid[nr][nc] = level;
                }
            }

            level++;
        }
    }
}
