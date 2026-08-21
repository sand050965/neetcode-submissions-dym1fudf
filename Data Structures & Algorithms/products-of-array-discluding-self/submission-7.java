class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        
        int product = 1;
        for (int i = 1; i < n; i++) {
            product *= nums[i - 1];
            result[i] *= product;
        }

        product = 1;
        for (int i = n - 2; i >= 0; i--) {
            product *= nums[i + 1];
            result[i] *= product;
        }

        return result;
    }
}  
