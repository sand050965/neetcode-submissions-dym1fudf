class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 100000000);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int end = Math.min(n, i + nums[i] + 1);
            for (int j = i + 1; j < end; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }

        return dp[0];
    }
}
