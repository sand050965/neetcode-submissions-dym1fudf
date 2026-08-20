class Solution {
    int[] memo1, memo2;
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        memo1 = new int[n];
        memo2 = new int[n];

        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        return Math.max(dfs(nums, memo1, n, 0, true), dfs(nums, memo2, n, 1, false));
    }

    private int dfs(int[] nums, int[] memo, int n, int i, boolean flag) {
        if ((flag && i >= n - 1) || (!flag && i >= n))
            return 0;

        if (memo[i] != -1) 
            return memo[i];
        
        return memo[i] = Math.max(nums[i] + dfs(nums, memo, n, i + 2, flag), dfs(nums, memo, n, i + 1, flag));
    }
}
