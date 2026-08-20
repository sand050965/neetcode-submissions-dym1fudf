class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> nextDP = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry: dp.entrySet()) {
                int sum = entry.getKey();
                int count = entry.getValue();

                nextDP.put(sum + nums[i], nextDP.getOrDefault(sum + nums[i], 0) + count);
                nextDP.put(sum - nums[i], nextDP.getOrDefault(sum - nums[i], 0) + count);
            }
            dp = nextDP;
        }

        return dp.getOrDefault(target, 0);
    }
}
