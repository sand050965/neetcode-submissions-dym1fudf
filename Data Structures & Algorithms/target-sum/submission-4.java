class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashMap<>();
        }

        dp[0].put(0, 1);

        for (int i = 0; i < n; i++) {
            for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                int sum = entry.getKey();
                int count = entry.getValue();
                int num = nums[i];

                Map<Integer, Integer> map = dp[i + 1];
                map.put(sum + num, map.getOrDefault(sum + num, 0) + count);
                map.put(sum - num, map.getOrDefault(sum - num, 0) + count);
            }
        }

        return dp[n].getOrDefault(target, 0);
    }
}
