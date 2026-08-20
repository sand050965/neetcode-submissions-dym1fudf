class Solution {
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        return Math.max(dp(nums, 0, n - 2), dp(nums, 1, n - 1));
    }

    private int dp(int[] nums, int l, int r) {
        int prev1 = nums[l];
        int prev2 = Math.max(nums[l], nums[l + 1]);

        for (int i = 2; i < n - 1; i++) {
            int curr = Math.max(prev2, prev1 + nums[l + i]);
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}
