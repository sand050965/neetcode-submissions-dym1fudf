class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int i = n - 1; i >= 0; i--) {
            int num1 = nums[i];
            for (int j = i; j < n; j++) {
                int num2 = nums[j];
                if (num1 < num2) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
