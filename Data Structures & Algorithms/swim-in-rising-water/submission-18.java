class Solution {
    public int swimInWater(int[][] grid) {
        int result = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        Set<String> visit = new HashSet<>();
        minHeap.offer(new int[] {0, 0, grid[0][0]});
        
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            result = Math.max(result, t);

            if (r == ROWS - 1 && c == COLS - 1) {
                break;
            }

            String key = r + "," + c;

            if (visit.contains(key)) {
                continue;
            }

            visit.add(key);

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                String nkey = nr + "," + nc;
                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || visit.contains(nkey)) {
                    continue;
                }

                minHeap.offer(new int[] {nr, nc, grid[nr][nc]});
            }
        }

        return result;
    }
}
