class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2, n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][target] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = target - 1; j >= 0; j--) {
                int num = nums[i];
                dp[i][j] = dp[i + 1][j];

                if (j + num <= target) {
                    dp[i][j] |= dp[i + 1][j + num];
                }
            }
        }

        return dp[0][0];
    }
}
