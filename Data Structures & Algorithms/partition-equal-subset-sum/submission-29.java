class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i + 1][j];

                if (j - num >= 0) {
                    dp[i][j] |= dp[i + 1][j - num];
                }
            }
        }

        return dp[0][target];
    }
}
