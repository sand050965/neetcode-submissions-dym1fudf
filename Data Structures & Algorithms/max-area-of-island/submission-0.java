class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int result = 0;

        for(int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) continue;
                result = Math.max(result, bfs(grid, ROWS, COLS, r, c));
            }
        }

        return result;
    }

    private int bfs(int[][] grid, int ROWS, int COLS, int r, int c) {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{r, c});
        grid[r][c] = 0;
        int area = 1;

        while (!dq.isEmpty()) {
            int[] pair = dq.poll();
            r = pair[0];
            c = pair[1];

            for (int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] == 0)
                    continue;
                
                grid[nr][nc] = 0;
                dq.offer(new int[]{nr, nc});
                area++;
            }
        }

        return area;
    }
}
