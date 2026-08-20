class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int minH = grid[0][0], maxH = grid[0][0];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int val = grid[r][c];
                minH = Math.min(minH, val);
                maxH = Math.max(maxH, val);
            }
        }

        int l = minH, r = maxH;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (dfs(grid, visit, 0, 0, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }

            for (int row = 0; row < n; row++) {
                Arrays.fill(visit[row], false);
            }
        }

        return r;
    }

    private boolean dfs(int[][] grid, boolean[][] visit, int r, int c, int t) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid.length || visit[r][c] || grid[r][c] > t)
            return false;

        if (r == grid.length - 1 && c == grid.length - 1)
            return true;
        
        visit[r][c] = true;
        
        return dfs(grid, visit, r + 1 , c, t) ||
                dfs(grid, visit, r, c + 1, t) ||
                dfs(grid, visit, r - 1, c, t) ||
                dfs(grid, visit, r, c - 1, t);
    }
}
