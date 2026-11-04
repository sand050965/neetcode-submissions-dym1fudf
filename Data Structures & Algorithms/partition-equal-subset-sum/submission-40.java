class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int n = nums.length, targetSum = sum / 2;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][targetSum] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            for (int j = targetSum - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];

                if (j <= targetSum - num) {
                    dp[i][j] |= dp[i + 1][j + num];
                }
            }
        }

        return dp[0][0];
    }
}
