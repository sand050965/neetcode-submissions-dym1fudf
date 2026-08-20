class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int minProduct = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int min = minProduct, max = maxProduct;
            min = Math.min(num * minProduct, num * maxProduct);
            min = Math.min(min, num);

            max = Math.max(num * minProduct, num * maxProduct);
            max = Math.max(max, num);

            minProduct = min;
            maxProduct = max;

            result = Math.max(result, maxProduct);
        }

        return result;
    }
}
