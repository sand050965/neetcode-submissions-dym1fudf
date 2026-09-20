class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], result = max;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0) {
                min = 1;
                max = 1;
            }

            int minCopy = min, maxCopy = max;
            min = Math.min(num, Math.min(num * minCopy, num * maxCopy));
            max = Math.max(num, Math.max(num * minCopy, num * maxCopy));

            result = Math.max(result, max);
        }

        return result;
    }
}
