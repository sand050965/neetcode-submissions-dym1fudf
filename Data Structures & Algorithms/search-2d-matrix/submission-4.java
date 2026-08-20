class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int ROWS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = ROWS * COLS - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int row = mid / COLS;
            int col = mid % COLS;

            if (matrix[row][col] == target) {
                return true;
            }

            if (target < matrix[row][col]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
