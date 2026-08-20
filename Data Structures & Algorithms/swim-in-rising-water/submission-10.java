class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2])); // [r, c, t]
        Set<String> visit = new HashSet<>();
        int time = 0;

        minHeap.offer(new int[] {0, 0, grid[0][0]});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            String key = r + "," + c;

            time = Math.max(time, t);
            visit.add(key);

            if (r == n - 1 && c == n - 1) {
                return time;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                String nkey = nr + "," + nc;
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visit.contains(nkey)) {
                    continue;
                }

                int nt = grid[nr][nc];
                minHeap.offer(new int[] {nr, nc, nt});
            }
        }

        return 0;
    }
}
