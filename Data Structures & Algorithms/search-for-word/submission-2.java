class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROWS = 0;
    int COLS = 0;
    int n = 0;
    
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        n = word.length();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] != word.charAt(0)) {
                    continue;
                }

                if(dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '1' || board[r][c] != word.charAt(idx)) {
            return false;
        }

        if (idx == n - 1 && board[r][c] == word.charAt(idx)) {
            return true;
        }

        char ch = board[r][c];
        board[r][c] = '1';

        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (dfs(board, word, newR, newC, idx + 1)) {
                return true;
            }
        }

        board[r][c] = ch;

        return false;
    }
}
