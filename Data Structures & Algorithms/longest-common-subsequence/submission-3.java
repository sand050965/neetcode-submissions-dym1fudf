class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[] prevRow = new int[n + 1];

        for (int i = m - 1; i >= 0; i--) {
            int[] row = new int[n + 1];

            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    row[j] = 1 + prevRow[j + 1];
                } else {
                    row[j] = Math.max(prevRow[j], row[j + 1]);
                }
            }

            prevRow = row;
        }

        return prevRow[0];
    }
}
