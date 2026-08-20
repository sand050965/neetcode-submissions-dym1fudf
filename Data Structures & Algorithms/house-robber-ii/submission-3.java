class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        return Math.max(
            helper(Arrays.copyOf(nums, n - 1), n - 1),
            helper(Arrays.copyOfRange(nums, 1, n), n - 1)
        );
    }

    private int helper(int[] nums, int n) {
        int rob1 = 0, rob2 = 0;

        for (int i = 0; i < n; i++) {
            int temp = rob2;
            rob2 = Math.max(nums[i] + rob1, rob2);
            rob1 = temp;
        }

        return rob2;
    }
}
