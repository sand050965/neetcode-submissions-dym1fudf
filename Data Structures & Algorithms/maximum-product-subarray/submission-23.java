class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = 1, maxProduct = 1, result = nums[0];
        for (int num : nums) {
            int minProductCopy = Math.min(num, Math.min(minProduct * num, maxProduct * num));
            int maxProductCopy = Math.max(num, Math.max(minProduct * num, maxProduct * num));

            minProduct = Math.min(minProductCopy, maxProductCopy);
            maxProduct = Math.max(minProductCopy, maxProductCopy);

            result = Math.max(result, maxProduct);

            if (minProduct == 0) {
                minProduct = 1;
            }

            if (maxProduct == 0) {
                maxProduct = 1;
            }
        }

        return result;
    }
}
