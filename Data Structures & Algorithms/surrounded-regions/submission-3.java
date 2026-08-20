class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROWS;
    int COLS;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = '*';
                dfs(board, 0, c);
            }

            if (board[ROWS - 1][c] == 'O') {
                board[ROWS - 1][c] = '*';
                dfs(board, ROWS - 1, c);
            }
        }

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = '*';
                dfs(board, r, 0);
            }

            if (board[r][COLS - 1] == 'O') {
                board[r][COLS - 1] = '*';
                dfs(board, r, COLS - 1);
            }
        }

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
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || board[nr][nc] != 'O') {
                continue;
            }

            board[nr][nc] = '*';
            dfs(board, nr, nc);
        }
    }
}
