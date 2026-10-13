class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = dp(nums, n, 0);
        int[] dp2 = dp(nums, n, 1);

        return Math.max(dp1[0], dp2[0]);
    }

    private int[] dp(int[] nums, int n, int offset) {
        int[] dp = new int[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i + offset] + dp[i + 2], dp[i + 1]);
        }

        return dp;
    }
}
