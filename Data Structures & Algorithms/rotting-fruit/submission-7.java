class Solution {
    int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int result = 0;
        int freshFruitsCnt = 0;
        Queue<int[]> dq = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int fruit = grid[r][c];
                if (fruit == 0) {
                    continue;
                }

                if (fruit == 1) {
                    freshFruitsCnt++;
                }

                if (fruit == 2) {
                    dq.offer(new int[] {r, c});
                }
            }
        }
        
        while (!dq.isEmpty() && freshFruitsCnt > 0) {
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

                    dq.offer(new int[] {nr, nc});
                    grid[nr][nc] = 2;
                    freshFruitsCnt--;
                }
            }

            result++;
        }

        return (freshFruitsCnt != 0) ? -1 : result;
    }
}
