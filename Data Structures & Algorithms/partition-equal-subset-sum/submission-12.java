class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int r = 0; r < n + 1; r++) {
            dp[r][target] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = target - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + nums[i] <= target) {
                    dp[i][j] |= dp[i + 1][j + nums[i]];
                }

                if (dp[i][0]) {
                    return true;
                }
            }
        }

        return dp[0][0];
    }
}
