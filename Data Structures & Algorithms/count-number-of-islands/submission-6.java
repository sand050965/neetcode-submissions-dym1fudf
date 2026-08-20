class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int result = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '0') continue;
                bfs(grid, ROWS, COLS, r, c);
                result++;
            }
        }

        return result;
    }

    private void bfs(char[][] grid, int ROWS, int COLS, int r, int c) {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{r, c});
        grid[r][c] = '0';
       
        while (!dq.isEmpty()) {
            int[] cell = dq.poll();
            r = cell[0];
            c = cell[1];
            
            for (int[] dir: dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR < 0 || newR >= ROWS || newC < 0 || newC >= COLS ||grid[newR][newC] == '0') {
                    continue;
                }

                dq.offer(new int[]{newR, newC});
                grid[newR][newC] = '0';
            }
        }
    }
}
