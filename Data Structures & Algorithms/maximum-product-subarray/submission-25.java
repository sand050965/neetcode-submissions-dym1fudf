class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1, result = nums[0];

        for (int num : nums) {
            int minCopy = min, maxCopy = max;
            min = Math.min(num, Math.min(num * minCopy, num * maxCopy));
            max = Math.max(num, Math.max(num * minCopy, num * maxCopy));
            result = Math.max(result, max);
        }

        return result;
    }
}
