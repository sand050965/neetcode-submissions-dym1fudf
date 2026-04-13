class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int max = 0;
        int result = 0;
        while (r < n - 1) {
            result++;
            for (int i = l; i <= r; i++) {
                max = Math.max(max, i + nums[i]);
            }
            l = r + 1;
            r = max;
        }

        return result;
    }
}
