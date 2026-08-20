class Solution {
    int[] dirX = {1, -1, 0, 0};
    int[] dirY = {0, 0, 1, -1}; 

    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length, result = 0;
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0' || visit[i][j])
                    continue;

                bfs(grid, visit, i, j);
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
}
