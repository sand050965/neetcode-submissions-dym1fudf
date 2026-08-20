class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        int result = 1;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(nums, n, i));
        }

        return result;
    }

    private int dfs(int[] nums, int n, int i) {
        if (i == n - 1)
            return dp[i] = 1;

        if (dp[i] != -1)
            return dp[i];

        int result = 1;
        for (int j = i + 1; j < n; j++) {
            if (nums[i] < nums[j])
                result = Math.max(result, 1 + dfs(nums, n, j));
        }

        return dp[i] = result;
    }
}
