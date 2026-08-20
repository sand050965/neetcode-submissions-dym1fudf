class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROWS;
    int COLS;
    Queue<int[]> dq = new ArrayDeque<>();

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                // dfs(board, 0, c);
                dq.offer(new int[]{0, c});
            }

            if (board[ROWS - 1][c] == 'O') {
                dfs(board, ROWS - 1, c);
                dq.offer(new int[]{ROWS - 1, c});
            }
        }

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                // dfs(board, r, 0);
                dq.offer(new int[]{r, 0});
            }

            if (board[r][COLS - 1] == 'O') {
                // dfs(board, r, COLS - 1);
                dq.offer(new int[]{r, COLS - 1});
            }
        }

        bfs(board);

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'X') {
                    continue;
                }


                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } 
                
                if (board[r][c] == '*') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '*';

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(board, nr, nc);
        }
    }

    private void bfs(char[][] board) {
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0];
            int c = curr[1];
            board[r][c] = '*';

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || board[nr][nc] != 'O') {
                    continue;
                }

                board[nr][nc] = '*';
                dq.offer(new int[]{nr, nc});
            }
        }
    }
}
