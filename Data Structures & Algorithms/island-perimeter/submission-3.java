class Solution {
    int[] dirX = new int[]{1, -1, 0, 0};
    int[] dirY = new int[]{0, 0, 1, -1};

    public int islandPerimeter(int[][] grid) {
        int row = grid.length, col = grid[0].length, perimeter = 0;
        boolean[][] visit = new boolean[row][col];

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 || visit[i][j])
                    continue;

                perimeter = dfs(grid, visit, i, j);
            }
        }

        return perimeter;
    }

    private int bfs(int[][] grid, boolean[][] visit, int x, int y) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{x, y});
        visit[x][y] = true;
        int perimeter = 0;

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + dirX[i];
                int nextY = curr[1] + dirY[i];

                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                    perimeter++;
                    continue;
                }

                if (grid[nextX][nextY] == 0) {
                    perimeter++;
                    continue;
                }
                
                if (visit[nextX][nextY])
                    continue;

                visit[nextX][nextY] = true;
                dq.offer(new int[]{nextX, nextY});
            }
        }

        return perimeter;
    }

    private int dfs (int[][] grid, boolean[][] visit, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return 1;

        if (grid[x][y] == 0)
            return 1;

        if (visit[x][y])
            return 0;
        
        visit[x][y] = true;
        int perimeter = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            perimeter += dfs(grid, visit, nextX, nextY);
        }

        return perimeter;
    }
}