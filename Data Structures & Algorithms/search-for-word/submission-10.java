class Solution {
    int ROWS, COLS;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    StringBuilder sb = new StringBuilder();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (recurse(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean recurse(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '.' || board[r][c] != word.charAt(idx)) {
            return false;
        }

        char ch = board[r][c];
        sb.append(ch);
        board[r][c] = '.';

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (recurse(board, word, nr, nc, idx + 1)) {
                return true;
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        board[r][c] = ch;

        return false;
    }
}
