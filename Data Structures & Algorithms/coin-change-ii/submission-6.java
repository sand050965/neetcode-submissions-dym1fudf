class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int a = 0;  a <= amount; a++) {
                dp[i][a] = (a - coins[i] >= 0) ?
                    dp[i + 1][a] + dp[i][a - coins[i]] :
                    dp[i + 1][a];
            }
        }

        return dp[0][amount];
    }
}
