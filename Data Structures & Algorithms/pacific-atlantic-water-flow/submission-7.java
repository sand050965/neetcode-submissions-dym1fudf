class Solution {
    int ROWS, COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] pacific, atlantic;
    Set<String> visited = new HashSet<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        
        pacific = new boolean[ROWS][COLS];
        atlantic = new boolean[ROWS][COLS];
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific, 0);
            dfs(heights, r, COLS - 1, atlantic, 0);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific, 0);
            dfs(heights, ROWS - 1, c, atlantic, 0);
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

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean, int prevHeight) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        ocean[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            dfs(heights, nr, nc, ocean, heights[r][c]);
        }
    }
}
