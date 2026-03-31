class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }

            int num = nums[i];
            sum += num;
            result = Math.max(result, sum);
        }

        return result;
    }
}
