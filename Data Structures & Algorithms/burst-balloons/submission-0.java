class Solution {
    Integer[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        for (int i = 0; i < n; i++)
            newNums[i + 1] = nums[i];
        newNums[0] = newNums[n + 1] = 1;
        memo = new Integer[n + 2][n + 2];

        return dfs(newNums, 1, n);
    }

    private int dfs(int[] nums, int l, int r) {
        if (l > r)
            return 0;
        
        if (memo[l][r] != null)
            return memo[l][r];

        memo[l][r] = 0;
        for (int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, i + 1, r) + dfs(nums, l, i - 1);
            memo[l][r] = Math.max(memo[l][r], coins);
        }

        return memo[l][r];
    }
}
