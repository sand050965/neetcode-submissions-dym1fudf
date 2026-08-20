class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int result = 1;
        Arrays.fill(dp, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }
}
