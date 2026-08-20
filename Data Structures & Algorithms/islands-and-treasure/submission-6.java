class Solution {
    int ROWS;
    int COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Queue<int[]> dq = new ArrayDeque<>();
    boolean[][] visited;

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != 0) {
                    continue;
                }

                dq.offer(new int[]{r, c});
            }
        }

        bfs(grid);
    }

    private void bfs(int[][] grid) {
        boolean[][] visited = new boolean[ROWS][COLS];

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || visited[nr][nc] || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }


                grid[nr][nc] = grid[r][c] + 1;
                dq.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
