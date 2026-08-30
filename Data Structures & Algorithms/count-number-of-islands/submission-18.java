class Solution {
    int ROWS, COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int result = 0;
    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != '1') {
                    continue;
                }

                bfs(grid, r, c);
                result++;
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] != '1') {
            return;
        }

        grid[r][c] = '.';

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {row, col});

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0], c = curr[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] != '1') {
                    continue;
                }

                dq.offer(new int[] {nr, nc});
                grid[nr][nc] = '.';
            }
        }
    }
}
