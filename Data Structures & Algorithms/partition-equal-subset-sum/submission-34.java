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
            dp[i][target] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            for (int j = target - 1; j >= 0; j--) {
                if (num + j <= target) {
                    dp[i][j] = dp[i + 1][j + num] || dp[i + 1][j];
                    continue;
                }

                dp[i][j] = dp[i + 1][j];
            }
        }

        return dp[0][0];
    }
}
