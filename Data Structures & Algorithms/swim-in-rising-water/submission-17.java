class Solution {
    int ROWS, COLS;
    int result = 0;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Set<String> visit = new HashSet<>();

    public int swimInWater(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;

        bfs(grid, 0, 0, grid[0][0]);

        return result;
    }

    private void bfs(int[][] grid, int row, int col, int height) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        minHeap.offer(new int[] {row, col, height});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int r = curr[0], c = curr[1], h = curr[2];
            result = Math.max(result, h);

            if (r == ROWS - 1 && c == COLS - 1) {
                break;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS) {
                    continue;
                }

                String key = nr + "," + nc;
                if (visit.contains(key)) {
                    continue;
                }

                minHeap.offer(new int[] {nr, nc, grid[nr][nc]});
                visit.add(key);
            }
        }
    }
}
