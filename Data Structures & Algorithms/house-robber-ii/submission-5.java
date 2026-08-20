class Solution {
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        return Math.max(dp(nums, 0, n - 2), dp(nums, 1, n - 1));
    }

    private int dp(int[] nums, int l, int r) {
        int[] dp = new int[n];
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);

        for (int i = l + 2; i <= r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[r];
    }
}
