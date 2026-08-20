class Solution {
    int ROWS;
    int COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Queue<int[]> dq = new ArrayDeque<>();

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != 0) {
                    continue;
                }

                dq.offer(new int[]{r, c, 0});
            }
        }

        bfs(grid);
    }

    private void bfs(int[][] grid) {
        boolean[][] visited = new boolean[ROWS][COLS];

        while (!dq.isEmpty()) {
            int size = dq.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                int r = curr[0];
                int c = curr[1];
                int dist = curr[2];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    int ndist = dist + 1;

                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || visited[nr][nc] || grid[nr][nc] == -1) {
                        continue;
                    }

                    if (grid[nr][nc] == Integer.MAX_VALUE) {
                        grid[nr][nc] = ndist;
                    }

                    dq.offer(new int[]{nr, nc, ndist});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
