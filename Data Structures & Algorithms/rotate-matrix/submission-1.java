class Solution {
    public void rotate(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        
        for (int r = 0; r < ROWS / 2; r++) {
            int[] temp = matrix[r];
            matrix[r] = matrix[ROWS - r - 1];
            matrix[ROWS - r - 1] = temp;
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = r; c < COLS; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }
}
