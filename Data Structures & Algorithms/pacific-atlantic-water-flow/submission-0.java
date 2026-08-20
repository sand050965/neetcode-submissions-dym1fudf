class Solution {
    int ROWS, COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Set<String> pacific = new HashSet<>(), atlantic = new HashSet<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for (int c = 0; c < COLS; c++) {
            dfs(heights, pacific, 0, c, heights[0][c]);
            dfs(heights, atlantic, ROWS - 1, c, heights[ROWS - 1][c]);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, pacific, r, 0, heights[r][0]);
            dfs(heights, atlantic, r, COLS - 1, heights[r][COLS - 1]);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                String key = r + "," + c;
                if (pacific.contains(key) && atlantic.contains(key))
                    result.add(List.of(r, c));
            }
        }

        return result;
    }

    private void dfs(int[][] heights, Set<String> visited, int r, int c, int prevHeight) {
        String key = r + "," + c;
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visited.contains(key) || heights[r][c] < prevHeight)
            return;
        
        visited.add(key);

        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(heights, visited, newR, newC, heights[r][c]);
        }
    }
}
