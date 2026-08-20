class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int dst = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= dst) {
                dst = i;
            }
        }

        return dst == 0;
    }
}
