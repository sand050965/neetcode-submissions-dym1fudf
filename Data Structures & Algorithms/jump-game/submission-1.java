class Solution {
    Map<Integer, Boolean> memo = new HashMap<>();
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return dfs(nums, n, 0);
    }

    private boolean dfs(int[] nums, int n, int i) {
        if (i >= n - 1)
            return true;
        
        if (nums[i] == 0)
            return false;

        if (memo.containsKey(i))
            return memo.get(i);

        int end = Math.min(nums.length, i + nums[i] + 1);
        for (int j = i + 1; j < end; j++) {
            if (dfs(nums, n, j)) {
                memo.put(i, true);
                return true;
            }
        }
        
        memo.put(i, false);
        return false;
    }
}
