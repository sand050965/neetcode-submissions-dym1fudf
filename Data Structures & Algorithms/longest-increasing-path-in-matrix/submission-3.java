class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int[][] indegree = new int[ROWS][COLS];
        Queue<int[]> dq = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                for (int[] dir: dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || matrix[r][c] <= matrix[nr][nc])
                        continue;
                    
                    indegree[r][c]++;
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (indegree[r][c] > 0)
                    continue;

                dq.offer(new int[] {r, c});
            }
        }

        int result = 0;
        while (!dq.isEmpty()) {
            for (int i = dq.size() - 1; i >= 0; i--) {
                int[] curr = dq.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir: dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || matrix[r][c] >= matrix[nr][nc])
                        continue;
                    
                    if (--indegree[nr][nc] == 0)
                        dq.offer(new int[] {nr, nc});
                }
            }
            result++;   
        }

        return result;
    }
}
