class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        memo = new Boolean[n][target + 1];

        return dfs(nums, n, 0, target);
    }

    private boolean dfs(int[] nums, int n, int i, int target) {
        if (i == n)
            return target == 0;
        
        if (target < 0)
            return false;

        if (memo[i][target] != null)
            return memo[i][target];

        return memo[i][target] = dfs(nums, n, i + 1, target) || dfs(nums, n, i + 1, target - nums[i]);
    }
}
