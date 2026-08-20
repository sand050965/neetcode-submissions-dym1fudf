class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else if (target > matrix[mid][n - 1]) {
                top = mid + 1;
            } else {
                break;
            }
        }

        if (top > bottom) 
            return false;

        int left = 0, right = n - 1;
        int row = top + (bottom - top) / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target)
                return true;

            if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
