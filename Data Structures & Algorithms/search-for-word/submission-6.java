class Solution {
    int ROWS, COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != word.charAt(idx)) {
            return false;
        }

        boolean result = false;
        char ch = board[r][c];
        board[r][c] = '.';
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            result |= dfs(board, word, nr, nc, idx + 1);
        }
        board[r][c] = ch;

        return result;
    }
}
