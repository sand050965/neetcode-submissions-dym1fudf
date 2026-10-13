class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = sum(nums, n);

        if (sum % 2 != 0) {
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
                    dp[i][j] = dp[i + 1][j] || dp[i + 1][j + num];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }

    private int sum(int[] nums, int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
