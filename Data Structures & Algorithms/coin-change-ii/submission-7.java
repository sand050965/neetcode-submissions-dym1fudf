class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            int[] nextDP = new int[amount + 1];
            nextDP[0] = 1;

            for (int a = 1; a <= amount; a++) {
                    nextDP[a] = dp[a];
                    nextDP[a] = (a - coins[i] >= 0) ?
                        nextDP[a] + nextDP[a - coins[i]] :
                        nextDP[a];
            }
            dp = nextDP;
        }

        return dp[amount];
    }
}
