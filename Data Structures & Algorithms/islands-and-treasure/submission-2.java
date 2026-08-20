class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int INF = 2147483647;
    int ROWS;
    int COLS;
    

    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != 0) {
                    continue;
                }

                bfs(grid, r, c);
            }
        }
    }

    private void bfs(int[][] grid, int row, int col) {
        int dist = 0;
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> dq = new ArrayDeque<>();

        dq.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!dq.isEmpty()) {
            int size = dq.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] == -1 || visited[nr][nc]) {
                        continue;
                    }

                    if (grid[nr][nc] != -1 && grid[nr][nc] != 0) {
                        grid[nr][nc] = Math.min(grid[nr][nc], dist);
                    }

                    dq.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
