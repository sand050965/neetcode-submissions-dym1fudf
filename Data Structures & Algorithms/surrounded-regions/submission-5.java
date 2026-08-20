class Solution {
    int ROWS;
    int COLS;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        Queue<int[]> dq = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (
                    (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1)
                    && board[r][c] == 'O'
                ) {
                    dq.offer(new int[] {r, c});
                    board[r][c] = '*';
                }
            }
        }

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || board[nr][nc] != 'O') {
                    continue;
                }

                dq.offer(new int[] {nr, nc});
                board[nr][nc] = '*';
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

                if (board[r][c] == '*') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
