class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;

        boolean[][] rows = new boolean[N][N];
        boolean[][] cols = new boolean[N][N];
        boolean[][] boxes = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int curr = board[r][c] - '1';
                if (board[r][c] == '.') continue;

                int boxId = (r / 3) * 3 + c / 3;
                if (rows[r][curr] || cols[c][curr] || boxes[boxId][curr])
                    return false;

                rows[r][curr] = true;
                cols[c][curr] = true;
                boxes[boxId][curr] = true;
            }
        }

        return true;
    }
}
