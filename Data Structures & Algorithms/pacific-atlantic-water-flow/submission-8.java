class Solution {
    int ROWS, COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] pacific, atlantic;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        pacific = new boolean[ROWS][COLS];
        atlantic = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            bfs(heights, pacific, r, 0, 0);
            bfs(heights, atlantic, r, COLS - 1, 0);
        }

        for (int c = 0; c < COLS; c++) {
            bfs(heights, pacific, 0, c, 0);
            bfs(heights, atlantic, ROWS - 1, c, 0);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c, int prevHeight) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        ocean[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            dfs(heights, ocean, nr, nc, heights[r][c]);
        }
    }

    private void bfs(int[][] heights, boolean[][] ocean, int row, int col, int prevHeight) {
        Queue<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {row, col});
        ocean[row][col] = true;

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0], c = curr[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || ocean[nr][nc] || heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                dq.offer(new int[] {nr, nc});
                ocean[nr][nc] = true;
            }
        }
    }
}
