class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int fresh = 0, time = 0;
        Queue<int[]> dq = new ArrayDeque<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1)
                    fresh++;
                if (grid[r][c] == 2)
                    dq.offer(new int[]{r, c});
            }
        }

        while (fresh > 0 && !dq.isEmpty()) {
            for (int i = dq.size() - 1; i >= 0; i--) {
                int[] point = dq.poll();
                int r = point[0];
                int c = point[1];

                for (int[] dir: dirs) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if (newR < 0 || newR >= ROWS || newC < 0 || newC >= COLS || grid[newR][newC] != 1)
                        continue;
                    dq.offer(new int[]{newR, newC});
                    grid[newR][newC] = 2;
                    fresh--;
                }
            }
            time++;
        }

        return (fresh == 0) ? time : -1;
    }
}
