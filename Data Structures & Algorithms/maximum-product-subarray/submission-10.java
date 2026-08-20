class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int minProduct = min;
            int maxProduct = max;

            min = Math.min(
                Math.min(num * minProduct, num * maxProduct)
                , num
            );

            max = Math.max(
                Math.max(num * minProduct, num * maxProduct),
                num
            );

            result = Math.max(result, max);
        }

        return result;
    }
}
