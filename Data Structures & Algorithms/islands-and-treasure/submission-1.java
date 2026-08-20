class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROWS, COLS;

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> dq = new ArrayDeque<>();
        ROWS = grid.length;
        COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != 0)
                    continue;
                dq.offer(new int[]{r, c});
            }
        }

        while(!dq.isEmpty()) {
            int[] point = dq.poll();
            int r = point[0];
            int c = point[1];

            for (int[] dir: dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR < 0 || newR >= ROWS || newC < 0 || newC >= COLS || grid[newR][newC] != Integer.MAX_VALUE)
                    continue;
                dq.offer(new int[]{newR, newC});
                grid[newR][newC] = grid[r][c] + 1;
            }
        }
    }
}
