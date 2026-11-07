class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (num < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
