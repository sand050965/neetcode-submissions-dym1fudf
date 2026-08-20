class Solution {
    int ROWS;
    int COLS;
    int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        Queue<int[]> dqP = new ArrayDeque<>();
        Queue<int[]> dqA = new ArrayDeque<>();
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            dqP.offer(new int[] {r, 0});
            pacific[r][0] = true;

            dqA.offer(new int[] {r, COLS - 1});
            atlantic[r][COLS - 1] = true;
        }

        for (int c = 0; c < COLS; c++) {
            dqP.offer(new int[] {0, c});
            pacific[0][c] = true;

            dqA.offer(new int[] {ROWS - 1, c});
            atlantic[ROWS - 1][c] = true;
        }

        bfs(heights, dqP, pacific);
        bfs(heights, dqA, atlantic);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> dq, boolean[][] visit) {
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0];
            int c = curr[1];
            int height = heights[r][c];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || visit[nr][nc] || heights[nr][nc] < height) {
                    continue;
                }

                dq.offer(new int[] {nr, nc});
                visit[nr][nc] = true;
            }
        }
    }
}
