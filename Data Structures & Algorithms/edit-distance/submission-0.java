class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        memo = new Integer[n1 + 1][n2 + 1];
        int idx1 = 0, idx2 = 0;

        return dfs(word1, word2, n1, n2, idx1, idx2);
    }

    private int dfs(String word1, String word2, int n1, int n2, int idx1, int idx2) {
        if (idx1 >= n1)
            return n2 - idx2;

        if (idx2 >= n2)
            return n1 - idx1;

        if (memo[idx1][idx2] != null)
            return memo[idx1][idx2];

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return memo[idx1][idx2] = dfs(word1, word2, n1, n2, idx1 + 1, idx2 + 1);
        } else {
            return memo[idx1][idx2] = 1 + Math.min(
                dfs(word1, word2, n1, n2, idx1 + 1, idx2 + 1),
                Math.min(
                    dfs(word1, word2, n1, n2, idx1 + 1, idx2), 
                    dfs(word1, word2, n1, n2, idx1, idx2 + 1)
                )
            );
        }
    }
}
