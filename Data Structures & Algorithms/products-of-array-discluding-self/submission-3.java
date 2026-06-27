class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len], suffix = new int[len], result = new int[len];
        int product = 1;
        prefix[0] = product;
        for (int i = 1; i < len; i++) {
            int num = nums[i - 1];
            product *= num;
            prefix[i] = product;
        }

        product = 1;
        suffix[len - 1] = product;
        for (int i = len - 2; i >= 0; i--) {
            int num = nums[i + 1];
            product *= num;
            suffix[i] = product;
        }

        for (int i = 0; i < len; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  
