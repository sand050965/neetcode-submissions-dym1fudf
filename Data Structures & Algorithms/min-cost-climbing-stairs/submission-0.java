class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        cache = new int[n];
        Arrays.fill(cache, -1);

        return Math.min(dfs(cost, n, 0), dfs(cost, n, 1));
    }

    private int dfs(int[] cost, int n, int i) {
        if (i >= n) return 0;

        if (cache[i] != -1)
            return cache[i];
        
        return cache[i] = cost[i] + Math.min(dfs(cost, n, i + 1), dfs(cost, n, i + 2));
    }
}
