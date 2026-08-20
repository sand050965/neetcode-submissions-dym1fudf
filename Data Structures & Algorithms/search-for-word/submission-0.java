class Solution {
    int ROWS, COLS;
    Set<Pair<Integer, Integer>> path = new HashSet<>();
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        ROWS = board.length; 
        COLS = board[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (backtrack(board, word, r, c, 0)) return true;
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int idx) {
        if (idx >= word.length()) return true;

        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] != word.charAt(idx) || path.contains(new Pair<>(r, c)))
            return false;

        boolean result = false;
        path.add(new Pair<>(r, c));
        for (int[] dir : dirs) {
            result |= backtrack(board, word, r + dir[0], c + dir[1], idx + 1);
        }
        path.remove(new Pair<>(r, c));

        return result;
    }
}
