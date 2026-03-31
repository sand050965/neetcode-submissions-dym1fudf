class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int idx = 0;
        int max = 0;
        int result = 0;

        while (idx < n) {
            if (max >= n - 1) {
                return result;
            }

            int prevMax = max;

            for (int i = idx; i <= prevMax; i++) {
                max = Math.max(max, i + nums[i]);
            }

            idx = prevMax + 1;
            result++;
        }

        return -1;
    }
}
