class Solution {
    int[] dirX = {1, -1, 0, 0};
    int[] dirY = {0, 0, 1, -1}; 

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        boolean[][] visit = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0' || visit[i][j])
                    continue;

                dfs(grid, visit, i, j);
                result++;
            }
        }

        return result;
    }

    private void bfs(char[][] grid, boolean[][] visit, int x, int y) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[] {x, y});
        visit[x][y] = true;

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dirX[i];
                int nextY = curr[1] + dirY[i];

                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length)
                    continue;
                
                if (grid[nextX][nextY] == '0' || visit[nextX][nextY])
                    continue;
                
                dq.offer(new int[]{nextX, nextY});
                visit[nextX][nextY] = true;
            }
        }
    }

    private void dfs (char[][] grid, boolean[][] visit, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return;
        
        if (grid[x][y] == '0' || visit[x][y])
            return;

        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            dfs(grid, visit, nextX, nextY);
        }
    }
}
