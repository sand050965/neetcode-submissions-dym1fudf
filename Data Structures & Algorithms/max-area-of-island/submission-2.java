class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int result = 0;
    int ROWS;
    int COLS;

    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != 1) {
                    continue;
                }

                int area = dfs(grid, r, c);
                result = Math.max(result, area);
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] != 1) {
            return 0;
        }

        int area = 1;
        grid[r][c] = 2;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            area += dfs(grid, nr, nc);
        }

        return area;
    }
}
