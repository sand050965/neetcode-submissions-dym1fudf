class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(dp(nums, 0), dp(nums, 1));
    }

    private int dp(int[] nums, int offset) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i + offset] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
