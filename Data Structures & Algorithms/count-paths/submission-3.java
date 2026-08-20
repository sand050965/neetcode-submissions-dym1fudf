class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n + 1];
        
        for (int r = m - 1; r >= 0; r--) {
            int[] row = new int[n + 1];
            row[n - 1] = 1;

            for (int c = n - 2; c >= 0; c--) {
                row[c] = row[c + 1] +  prevRow[c];
            }

            prevRow = row;
        }

        return prevRow[0];
    }
}
