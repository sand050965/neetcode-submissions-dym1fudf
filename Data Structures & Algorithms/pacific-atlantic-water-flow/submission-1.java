class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROWS, COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        Queue<int[]> pac = new ArrayDeque<>(), atl = new ArrayDeque<>();
        boolean[][] pacVisited = new boolean[ROWS][COLS], atlVisited = new boolean[ROWS][COLS];
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            pac.offer(new int[]{r, 0});
            atl.offer(new int[]{r, COLS - 1});
        }

        for (int c = 0; c < COLS; c++) {
            pac.offer(new int[]{0, c});
            atl.offer(new int[]{ROWS - 1, c});
        }

        bfs(heights, pacVisited, pac);
        bfs(heights, atlVisited, atl);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacVisited[r][c] && atlVisited[r][c])
                    result.add(List.of(r, c));
            }
        }
        
        return result;
    }

    private void bfs (int[][] heights, boolean[][] visited, Queue<int[]> dq) {
        while (!dq.isEmpty()) {
            int[] point = dq.poll();
            int r = point[0], c = point[1];
            int height = heights[r][c];
            visited[r][c] = true;

            for (int[] dir: dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (newR < 0 || newR >= ROWS || newC < 0 || newC >= COLS || visited[newR][newC] || heights[newR][newC] < height)
                    continue;

                dq.offer(new int[]{newR, newC});
                visited[newR][newC] = true;
            }
        }
    }
}
