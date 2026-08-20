class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        int n = nums.length;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            Set<Integer> copy = new HashSet<>(dp);

            for (int subsetSum : dp) {
                copy.add(num + subsetSum);

                if (copy.contains(target)) {
                    return true;
                }
            }

            dp = copy;
        }

        return dp.contains(target);
    }
}
