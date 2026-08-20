class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];
        
        for (int i = 0; i < n; i++)
            newNums[i + 1] = nums[i];

        newNums[0] = newNums[n + 1] = 1;
        nums = newNums;

        for (int l = n; l >= 1; l--) {
            for (int r = l; r <= n; r++) {
                for (int i = l; i <= r; i++) {
                    int coins = nums[l - 1] * nums[i] * nums[r + 1];
                    coins += dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }

        return dp[1][n];
    }
}
