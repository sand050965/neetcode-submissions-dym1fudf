class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = 1, maxProduct = 1;
        int result = nums[0];

        for (int num : nums) {
            int minProductCopy = minProduct, maxProductCopy = maxProduct;
            minProduct = Math.min(num, Math.min(num * minProductCopy, num * maxProductCopy));
            maxProduct = Math.max(num, Math.max(num * minProductCopy, num * maxProductCopy));

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
