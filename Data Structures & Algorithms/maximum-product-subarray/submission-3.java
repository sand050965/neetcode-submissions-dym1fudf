class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (nums.length == 1) return nums[0];

        int min = nums[0], max = nums[0], result = max;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int temp = Math.max(
                num, 
                Math.max(max * num, min * num)
            );

            min = Math.min(
                num, 
                Math.min(max * num, min * num)
            );

            max = temp;

            result = Math.max(result, max);
        }

        return result;
    }
}
