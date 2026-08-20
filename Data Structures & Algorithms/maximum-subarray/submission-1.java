class Solution {
    Integer[][] memo;
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        memo = new Integer[n + 1][2];

        return dfs(nums, n, 0, false);
    }

    private int dfs(int[] nums, int n, int i, boolean flag) {
        if (i >= n)
            return flag ? 0 : Integer.MIN_VALUE;

        int f = flag? 1 : 0;
        if (memo[i][f] != null)
            return memo[i][f];

        if (flag)
            return memo[i][f] = Math.max(0, nums[i] + dfs(nums, n, i + 1, true));
        
        return memo[i][f] = Math.max(
            dfs(nums, n, i + 1, false),
            nums[i] + dfs(nums, n, i + 1, true)
        );
    }
}
