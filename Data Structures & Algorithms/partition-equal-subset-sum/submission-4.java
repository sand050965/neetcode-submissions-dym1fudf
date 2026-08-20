class Solution {
    public boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if (sum % 2 == 1) {
            return false;
        }

        int n = nums.length;
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = n - 1; i >= 0; i--) {
            Set<Integer> nextDp = new HashSet<>();
            for (int t : dp) {
                nextDp.add(t + nums[i]);
                nextDp.add(t);
            }
            dp = nextDp;
        }

        return dp.contains(target);
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }
}
