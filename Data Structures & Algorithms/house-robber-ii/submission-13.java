class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n + 1], dp2 = new int[n + 1];
        helper(nums, dp1, n, 0);
        helper(nums, dp2, n, 1);

        return Math.max(dp1[0], dp2[0]);
    }

    private void helper(int[] nums, int[] dp, int n, int offset) {
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i + offset] + dp[i + 2], dp[i + 1]);
        }
    }
}
