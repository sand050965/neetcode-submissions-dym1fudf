class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != 0) continue;
                dq.offer(new int[]{r, c, 0});
            }
        }

        while (!dq.isEmpty()) {
            int[] pair = dq.poll();
            int r = pair[0], c = pair[1], level = pair[2];
            visited[r][c] = true;
            grid[r][c] = Math.min(grid[r][c], level);

            for (int[] dir: dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR < 0 || newR >= ROWS || newC < 0 || newC >= COLS || visited[newR][newC] || grid[newR][newC] <= 0)
                    continue;
                dq.offer(new int[] {newR, newC, level + 1});
            }
        }
    }
}
