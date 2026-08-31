class Solution {
    int ROWS, COLS;
    int result = 0, cnt = 0;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Queue<int[]> dq = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    cnt++;
                }

                if (grid[r][c] == 2) {
                    dq.offer(new int[] {r, c});
                }
            }
        }

        while (!dq.isEmpty() && cnt > 0) {
            for (int i = dq.size(); i > 0; i--) {
                int[] curr = dq.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] != 1) {
                        continue;
                    }
                    grid[nr][nc] = 2;
                    dq.offer(new int[] {nr, nc});
                    cnt--;
                }
            }

            result++;
        }

        return (cnt == 0) ? result : -1;
    }
}
