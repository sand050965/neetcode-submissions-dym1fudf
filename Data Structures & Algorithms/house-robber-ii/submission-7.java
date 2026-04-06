class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        return Math.max(dp(nums, 0, n - 2), dp(nums, 1, n - 1));
    }

    private int dp(int[] nums, int l, int r) {
        int n = r - l + 1;
        if (n == 1) {
            return nums[l];
        }

        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[l + i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
