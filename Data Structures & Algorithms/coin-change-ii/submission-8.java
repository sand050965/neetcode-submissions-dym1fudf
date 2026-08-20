class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int a = 1; a <= amount; a++) {
                dp[a] = (a - coins[i] >= 0) ?
                    dp[a] + dp[a - coins[i]] :
                    dp[a];
            }
        }

        return dp[amount];
    }
}
