class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int minProduct = 1, maxProduct = 1, result = 0;
        for (int num : nums) {
            int minProductCopy = minProduct, maxProductCopy = maxProduct;
            minProduct = Math.min(num, Math.min(num * minProductCopy, num * maxProductCopy));
            maxProduct = Math.max(num, Math.max(num * minProductCopy, num * maxProductCopy));
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
