class Solution {
    public int swimInWater(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        minHeap.offer(new int[] {0, 0, grid[0][0]});

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int r = node[0], c = node[1], h = node[2];
            grid[r][c] = -1;

            if (r == ROWS - 1 && c == COLS - 1) {
                return h;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || grid[nr][nc] == -1) {
                    continue;
                }

                int nh = Math.max(h, grid[nr][nc]);
                grid[nr][nc] = -1;
                minHeap.offer(new int[] {nr, nc, nh});
            }
        }
        
        return -1;
    }
}
