class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int rob1 = nums[0], rob2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int temp = rob2;
            rob2 = Math.max(nums[i] + rob1, rob2);
            rob1 = temp;
        }

        return rob2;
    }
}
