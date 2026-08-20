class Solution {
    private int ROWS, COLS;
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (backtrack(board, word, r, c, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int i) {
        if (i >= word.length()) 
            return true;

        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != word.charAt(i) || board[r][c] == '*')
            return false;

        char ch = board[r][c];
        boolean result = false;
        for (int[] dir : dirs) {
            board[r][c] = '*';
            result |= backtrack(board, word, r + dir[0], c + dir[1], i + 1);
            board[r][c] = ch;
        }

        return result;
    }
}
