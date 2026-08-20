class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int result = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visit = new boolean[n][n];
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) return t;
            
            for (int[] dir: dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visit[nr][nc]) 
                    continue;
                
                visit[nr][nc] = true;
                int nt = Math.max(t, grid[nr][nc]);
                minHeap.offer(new int[]{nt, nr, nc});
            }
        }

        return 0;
    }
}
