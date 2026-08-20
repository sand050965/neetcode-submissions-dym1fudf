class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int l = 0, r = cols, t = 0, b = rows;

        while (l < r && t < b) {
            for (int i = l; i < r; i++) {
                result.add(matrix[t][i]);
            }
            t++;

            for (int i = t; i < b; i++) {
                result.add(matrix[i][r - 1]);
            }
            r--;

            if (!(l < r && t < b))
                break;

            for (int i = r - 1; i >= l; i--) {
                result.add(matrix[b - 1][i]);
            }
            b--;

            for (int i = b - 1; i >= t; i--) {
                result.add(matrix[i][l]);
            }
            l++;
        }

        return result;
    }
}
