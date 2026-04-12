class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = nums[0];
        int maxProduct = nums[0];
        int result = maxProduct;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int minProductCopy = minProduct;
            int maxProductCopy = maxProduct;

            minProduct = Math.min(
                num,
                Math.min(minProductCopy * num, maxProductCopy * num)
            );

            maxProduct = Math.max(
                num,
                Math.max(minProductCopy * num, maxProductCopy * num)
            );

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
