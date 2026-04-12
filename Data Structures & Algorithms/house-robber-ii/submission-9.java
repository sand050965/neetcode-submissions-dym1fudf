class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int amt1 = getDp(nums, n - 1, 0, n - 2);
        int amt2 = getDp(nums, n - 1, 1, n - 1);

        return Math.max(amt1, amt2);
    }

    private int getDp(int[] nums, int n, int start, int end) {
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i + start] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
