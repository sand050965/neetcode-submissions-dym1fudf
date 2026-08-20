class Solution {
    Integer[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        memo = new Integer[n][2 * total + 1];

        return dfs(nums, target, total, n, 0, 0);
    }

    private int dfs(int[] nums, int target, int total, int n, int i, int sum) {
        if (i >= n)
            return (sum == target) ? 1 : 0;
        
        if (memo[i][total + sum] != null)
            return memo[i][total + sum];

        return memo[i][total + sum] = (
            dfs(nums, target, total, n, i + 1, sum + nums[i]) +
            dfs(nums, target, total, n, i + 1, sum - nums[i])
        );
    }
}
