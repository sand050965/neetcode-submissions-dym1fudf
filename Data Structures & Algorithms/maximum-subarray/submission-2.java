class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        return dfs(nums, 0, n - 1);
    }

    private int dfs(int[] nums, int l, int r) {
        if (l > r)
            return Integer.MIN_VALUE;
        
        int mid = l + (r - l) / 2;

        int leftSum = 0, rightSum = 0, currSum = 0;

        for (int i = mid - 1; i >= 0; i--) {
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }

        currSum = 0;
        for (int i = mid + 1; i <= r; i++) {
            currSum += nums[i];
            rightSum = Math.max(rightSum, currSum);
        }

        return Math.max(
            leftSum + nums[mid] + rightSum,
            Math.max(
                dfs(nums, l, mid - 1),
                dfs(nums, mid + 1, r)
            )
        );
    }
}
