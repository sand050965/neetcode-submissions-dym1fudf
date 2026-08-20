class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int top = 0, right = COLS - 1, bottom = ROWS - 1, left = 0;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                result.add(matrix[top][c]);
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                result.add(matrix[r][right]);
            }
            right--;

            if (top > bottom || left > right) {
                break;
            }

            for (int c = right; c >= left; c--) {
                result.add(matrix[bottom][c]);
            }
            bottom--;

            for (int r = bottom; r >= top; r--) {
                result.add(matrix[r][left]);
            }
            left++;
        }

        return result;
    }
}
