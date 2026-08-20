class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROWS;
    int COLS;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, ROWS - 1, c, atlantic);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, COLS - 1, atlantic);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!pacific[r][c] || !atlantic[r][c]) {
                    continue;
                }

                result.add(List.of(r, c));
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean) {
        int height = heights[r][c];
        ocean[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || ocean[nr][nc] || heights[nr][nc] < height) {
                continue;
            }

            dfs(heights, nr, nc, ocean);
        }
    }
}
