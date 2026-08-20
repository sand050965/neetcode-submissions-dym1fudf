class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int result = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '0') 
                    continue;

                dfs(grid, ROWS, COLS, r, c);
                result++;
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int ROWS, int COLS, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == '0')
            return;

        grid[r][c] = '0';

        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(grid, ROWS, COLS, newR, newC);
        }
    }
}
