class Solution {
    int ROWS, COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int area = 0, result = 0;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != 1) {
                    continue;
                }

                dfs(grid, r, c);
                result = Math.max(result, area);
                area = 0;
            }
        }

        return result;
    }

    private void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 3;
        area++;

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            dfs(grid, nr, nc);
        }
    }
}
