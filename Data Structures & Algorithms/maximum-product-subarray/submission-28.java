class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = nums[0], max = nums[0], result = nums[0];
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int minCopy = min, maxCopy = max;
            min = Math.min(num, Math.min(num * minCopy, num * maxCopy));
            max = Math.max(num, Math.max(num * minCopy, num * maxCopy));

            result = Math.max(result, max);

            if (num == 0) {
                min = 1;
                max = 1;
            }
        }

        return result;
    }
}
