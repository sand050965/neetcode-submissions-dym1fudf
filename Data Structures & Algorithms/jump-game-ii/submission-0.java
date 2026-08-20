class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int result = 0, l = 0, r = 0;

        while (r < n - 1) {
            int nextR = 0;
            for (int i = l; i < r + 1; i++) {
                nextR = Math.max(nextR, i + nums[i]);
            }
            l = r + 1;
            r = nextR;
            result++;
        }

        return result;
    }
}
