class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProducts = new int[n], suffixProducts = new int[n], result = new int[n];
        
        int product = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                product *= nums[i - 1];
            }

            prefixProducts[i] = product;
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                product *= nums[i + 1];
            }

            suffixProducts[i] = product;
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }

        return result;
    }
}  
