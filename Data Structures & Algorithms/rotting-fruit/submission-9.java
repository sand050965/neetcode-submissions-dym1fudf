class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int fresh = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> dq = new ArrayDeque<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    fresh++;
                }

                if (grid[r][c] == 2) {
                    dq.offer(new int[] {r, c});
                }
            }
        }
        
        int result = 0;
        while (!dq.isEmpty() && fresh > 0) {
            result++;
            for (int i = dq.size(); i > 0; i--) {
                int[] curr = dq.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    fresh--;
                    dq.offer(new int[] {nr, nc});
                }
            }
        }

        return (fresh == 0) ? result : -1;
    }
}
